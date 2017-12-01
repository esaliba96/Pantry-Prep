package logic;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MyIngredientScene {

   static VBox vertDisplay;
   static VBox nameSection;
   static VBox descriptionSection;
   static VBox ingredientVbox;
   static VBox directionVbox;
   static HBox addIngredientStatus;
   static Button addIngredientButton;
   static Button addMyIngredientsButton;
   static TextField nameTextField;
   static TextField quantityTextField;
   static TextField ingredientTextField;
   static TextField descriptionTextField;
   static ComboBox unitComboBox;
   static int stepCount = 1;
   static int ingredientCount = 1;
   static ArrayList<TextField> instructionTextFieldList;
   static ArrayList<TextField> quantityTextFieldList;
   static ArrayList<ComboBox> unitComboBoxList;
   static ArrayList<TextField> ingredientNameTextFieldList;
   static ArrayList<Ingredient> ingredientList = new ArrayList<>();
   static ArrayList<String> instructionList = new ArrayList<>();
   static ObservableList<String> options;
   static Label fieldError;
   static Label recipeAdded;
   static boolean previousError = false;

   private MyIngredientScene() {
   }

   public static Scene getScene() {
      Group root = new Group();
      Double sceneWidth = PantryPrep.stage.getWidth();
      Double sceneHeight = PantryPrep.stage.getHeight();

      ScrollBar sc = new ScrollBar();
      sc.setLayoutX(sceneWidth - sc.getWidth() + 3);
      sc.setMin(0);
      sc.setOrientation(Orientation.VERTICAL);
      sc.setPrefHeight(sceneHeight * 2);
      sc.setMax(1200);

      // VBox for whole My Ingredients Scene
      vertDisplay = new VBox();
      vertDisplay.setSpacing(20);

      // Page Title
      Label pageTitle = new Label("My Ingredients");
      Label pageMemo = new Label("Enter the ingredients you have.");

      /*** Recipe Ingredients Label and Text Field ***/
      ingredientVbox = new VBox();
      Label ingredientLabel = new Label("Ingredients:");
      ingredientVbox.setSpacing(10);
      // Text Fields for each Ingredient
      quantityTextField = new TextField();
      HBox recipeTextFields = new HBox();
      quantityTextField.setPromptText("Quantity");
      options = FXCollections.observableArrayList(MeasurementUtil.getAllMeasurementNames());
      ingredientTextField = new TextField();
      unitComboBox = new ComboBox(options);
      ingredientTextField.setPromptText("Ingredient Name");
      ingredientVbox.getChildren().addAll(ingredientLabel, recipeTextFields);
      recipeTextFields.getChildren().addAll(quantityTextField, unitComboBox, ingredientTextField);
      addIngredientButton = new Button("Add Another Ingredient");
      addIngredientButton.setOnAction(MyIngredientScene::buttonClicked);
      // Create TextField Arrays and add to them
      quantityTextFieldList = new ArrayList<>();
      unitComboBoxList = new ArrayList<>();
      ingredientNameTextFieldList = new ArrayList<>();
      quantityTextFieldList.add(quantityTextField);
      unitComboBoxList.add(unitComboBox);
      ingredientNameTextFieldList.add(ingredientTextField);

      // Add Ingredients Button
      addMyIngredientsButton = new Button("Save My Ingredients");
      addMyIngredientsButton.setOnAction(MyIngredientScene::buttonClicked);

      //Add Recipe Button Status
      addIngredientStatus = new HBox();
      fieldError = new Label(
          "Blank Text Fields or Invalid Number Format of an Ingredient's Quantity");
      fieldError.setTextFill(Color.web("#cc0000"));
      recipeAdded = new Label("Successfully added Ingredients!");
      recipeAdded.setTextFill(Color.web("#006b3c"));

      // Add all sections to Scene's VBox
      vertDisplay.getChildren().addAll(NavigationBar.getNavigateBox(), pageTitle, pageMemo,
          ingredientVbox, addIngredientButton, addMyIngredientsButton, addIngredientStatus);

      sc.valueProperty().addListener(
          (ov, oldValue, newValue) -> vertDisplay.setLayoutY(-newValue.doubleValue()));

      root.getChildren().addAll(vertDisplay, sc);

      // Set screen size
      return new Scene(root, 400, 400);
   }

   public static void buttonClicked(ActionEvent e) {
      if (e.getSource() == addIngredientButton) {
         HBox recipeTextFields = new HBox();
         TextField quantityTextField = new TextField();
         unitComboBox = new ComboBox(options);
         quantityTextField.setPromptText("Quantity");
         TextField ingredientTextField = new TextField();
         unitComboBox = new ComboBox(options);
         ingredientTextField.setPromptText("Ingredient Name");
         recipeTextFields.getChildren().addAll(quantityTextField, unitComboBox, ingredientTextField);
         ingredientVbox.getChildren().addAll(recipeTextFields);
         quantityTextFieldList.add(quantityTextField);
         unitComboBoxList.add(unitComboBox);
         ingredientNameTextFieldList.add(ingredientTextField);
      } else if (e.getSource() == addMyIngredientsButton) {
         //Invalid text fields, display error message
         if (!validFieldCheck()) {
            if (!previousError) {
               addIngredientStatus.getChildren().add(fieldError);
               previousError = true;
            }
            return;
         }
         //If there was an error before, but not anymore clear the error message
         if (previousError) {
            addIngredientStatus.getChildren().clear();
            previousError = false;
         }
         //Display success message
         addIngredientStatus.getChildren().add(recipeAdded);
         previousError = true;

         transferIngredientList();
      }
   }

   public static boolean validFieldCheck() {
      for (int i = 0; i < quantityTextFieldList.size(); i++) {
         if (quantityTextFieldList.get(i).getText().equals("")
             || unitComboBoxList.get(i).getSelectionModel().isEmpty()
             || ingredientNameTextFieldList.get(i).getText().equals("")) {
            return false;
         }

         try {
            Integer.parseInt(quantityTextFieldList.get(i).getText());
         } catch (java.lang.NumberFormatException e) {
            return false;
         }
      }

      return true;
   }

   public static void transferIngredientList() {
      for (int i = 0; i < quantityTextFieldList.size(); i++) {
         ingredientList.add(getIngredient(Integer.parseInt(quantityTextFieldList.get(i).getText()),
             unitComboBoxList.get(i).getValue().toString(),
             ingredientNameTextFieldList.get(i).getText()));
      }
   }

   public static Ingredient getIngredient(int quantity, String unit, String ingredientName) {
      return new Ingredient(quantity, unit, ingredientName);
   }
}
