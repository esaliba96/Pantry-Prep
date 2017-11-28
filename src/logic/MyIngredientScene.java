package logic;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.lang.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;

public class MyIngredientScene {

	static VBox vertDisplay, nameSection, descriptionSection, ingredientVbox, directionVbox;
	static HBox addIngredientStatus;
	static Button addIngredientButton, addMyIngredientsButton;
	static TextField nameTextField, quantityTextField, ingredientTextField, descriptionTextField;
	static ComboBox unitComboBox;
	static int stepCount = 1;
	static int ingredientCount = 1;
	static ArrayList<TextField> instructionTextFieldList;
	static ArrayList<TextField> quantityTextFieldList;
	static ArrayList<ComboBox> unitComboBoxList;
	static ArrayList<TextField> ingredientNameTextFieldList;
	static ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	static ArrayList<String> instructionList = new ArrayList<String>();
	static ObservableList<String> options;
	static Label fieldError, recipeAdded;
	static boolean previousError = false; 

	public static Scene getScene(MyCalendar c) {
		Group root = new Group();
		Double sceneWidth = PantryPrep.stage.getWidth();
		Double sceneHeight = PantryPrep.stage.getHeight();
			
		ScrollBar sc = new ScrollBar();
		sc.setLayoutX(sceneWidth-sc.getWidth() + 3);
		sc.setMin(0);
		sc.setOrientation(Orientation.VERTICAL);
		sc.setPrefHeight(sceneHeight*2);
		sc.setMax(1200);

		// VBox for whole My Ingredients Scene
		vertDisplay = new VBox();
		vertDisplay.setSpacing(20);

		// Page Title
		Label pageTitle = new Label("My Ingredients");
		Label pageMemo = new Label("Enter the ingredients you have.");
		

		/*** Recipe Ingredients Label and Text Field ***/
		ingredientVbox = new VBox();
		ingredientVbox.setSpacing(10);
		Label ingredientLabel = new Label("Ingredients:");
		// Text Fields for each Ingredient
		HBox recipeTextFields = new HBox();
		quantityTextField = new TextField();
		quantityTextField.setPromptText("Quantity");
		options = FXCollections.observableArrayList(MeasurementUtil.getAllMeasurementNames());
		unitComboBox = new ComboBox(options);
		ingredientTextField = new TextField();
		ingredientTextField.setPromptText("Ingredient Name");
		// Add Ingredient text fields to HBox
		recipeTextFields.getChildren().addAll(quantityTextField, unitComboBox, ingredientTextField);
		// Add to Ingredient section VBox
		ingredientVbox.getChildren().addAll(ingredientLabel, recipeTextFields);
		// Add More Ingredient Button and Action
		addIngredientButton = new Button("Add Another Ingredient");
		addIngredientButton.setOnAction(e -> ButtonClicked(e));
		// Create TextField Arrays and add to them
		quantityTextFieldList = new ArrayList<TextField>();
		unitComboBoxList = new ArrayList<ComboBox>();
		ingredientNameTextFieldList = new ArrayList<TextField>();
		quantityTextFieldList.add(quantityTextField);
		unitComboBoxList.add(unitComboBox);
		ingredientNameTextFieldList.add(ingredientTextField);

		// Add Ingredients Button
		addMyIngredientsButton = new Button("Save My Ingredients");
		addMyIngredientsButton.setOnAction(e -> ButtonClicked(e));
		
		//Add Recipe Button Status
		addIngredientStatus = new HBox();
		fieldError = new Label("Blank Text Fields or Invalid Number Format of an Ingredient's Quantity");
		fieldError.setTextFill(Color.web("#cc0000"));
		recipeAdded = new Label("Successfully added Ingredients!");
		recipeAdded.setTextFill(Color.web("#006b3c"));

		// Add all sections to Scene's VBox
		vertDisplay.getChildren().addAll(NavigationBar.getNavigateBox(), pageTitle, pageMemo,
				ingredientVbox, addIngredientButton, addMyIngredientsButton, addIngredientStatus);
		
		
		sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    vertDisplay.setLayoutY(-new_val.doubleValue());
            }
        });
		
		root.getChildren().addAll(vertDisplay, sc);

		// Set screen size
		return new Scene(root, 400, 400);
	}

	static public void ButtonClicked(ActionEvent e) {
		if (e.getSource() == addIngredientButton) {
			ingredientCount++;
			HBox recipeTextFields = new HBox();
			TextField quantityTextField = new TextField();
			quantityTextField.setPromptText("Quantity");
			unitComboBox = new ComboBox(options);
			TextField ingredientTextField = new TextField();
			ingredientTextField.setPromptText("Ingredient Name");
			// Add Ingredient text fields to HBox
			recipeTextFields.getChildren().addAll(quantityTextField, unitComboBox, ingredientTextField);
			// Add to Ingredient section VBox
			ingredientVbox.getChildren().addAll(recipeTextFields);
			// Add text fields to lists
			quantityTextFieldList.add(quantityTextField);
			unitComboBoxList.add(unitComboBox);
			ingredientNameTextFieldList.add(ingredientTextField);
		} else if (e.getSource() == addMyIngredientsButton) {
			//Invalid text fields, display error message
			if (validFieldCheck() == false) {
				if(!previousError) {
					addIngredientStatus.getChildren().add(fieldError);
					previousError = true;
				}
				return;
			}
			//If there was an error before, but not anymore clear the error message
			if(previousError) {
				addIngredientStatus.getChildren().clear();
				previousError = false;
			}
			//Display success message
			if(!previousError) {
				addIngredientStatus.getChildren().add(recipeAdded);
				previousError=true;
			}
			
			transferIngredientList();
		}
	}

	static public boolean validFieldCheck() {
		for (int i = 0; i < quantityTextFieldList.size(); i++) {
			if (quantityTextFieldList.get(i).getText().equals("")
					|| unitComboBoxList.get(i).getSelectionModel().isEmpty()
					|| ingredientNameTextFieldList.get(i).getText().equals("")) {
				return false;
			}

			try {
				Integer.parseInt(quantityTextFieldList.get(i).getText());
			} catch (java.lang.NumberFormatException e) {
				System.err.println("NumberFormatException..: " + e.getMessage());
				return false;
			}
		}

		return true;
	}

	static public void transferIngredientList() {
		for (int i = 0; i < quantityTextFieldList.size(); i++) {
			System.out.println("*** " + unitComboBoxList.get(i).getValue().toString());
			ingredientList.add(getIngredient(Integer.parseInt(quantityTextFieldList.get(i).getText()),
					unitComboBoxList.get(i).getValue().toString(), ingredientNameTextFieldList.get(i).getText()));
		}
		for (int i = 0; i < ingredientList.size(); i++) {
			System.out.println(ingredientList.get(i));
		}
	}

	static public Ingredient getIngredient(int quantity, String unit, String ingredientName) {
		Ingredient item = new Ingredient(quantity, unit, ingredientName);
		return item;
	}
}
