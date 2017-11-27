package logic;

import java.io.UncheckedIOException;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;

class AddRecipeScene {

	private static VBox vertDisplay;
	private static VBox ingredientVbox;
	private static VBox directionVbox;
	private static HBox addRecipeStatus;
	private static Button addIngredientButton;
	private static Button addStepButton;
	private static Button addRecipe;
	private static TextField nameTextField;
	private static TextField descriptionTextField;
	private static ComboBox unitComboBox;
	private static int stepCount = 1;
	private static int ingredientCount = 1;
	private static ArrayList<TextField> instructionTextFieldList;
	private static ArrayList<TextField> quantityTextFieldList;
	private static ArrayList<ComboBox> unitComboBoxList;
	private static ArrayList<TextField> ingredientNameTextFieldList;
	private static ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private static ArrayList<String> instructionList = new ArrayList<String>();
	private static ObservableList<String> options;
	private static Label fieldError;
	private static Label recipeAdded;
	private static boolean previousError = false;

	private AddRecipeScene() {

	}

	@SuppressWarnings("unchecked")
	static Scene getScene(MyCalendar c) {
		VBox nameSection;
		VBox descriptionSection;
		TextField quantityTextField;
		TextField ingredientTextField;

		Group root = new Group();

		ScrollBar sc = new ScrollBar();
		sc.setMin(0);
		sc.setOrientation(Orientation.VERTICAL);
		sc.setPrefHeight(600);
		sc.setMax(1200);

		// VBox for whole Add Recipe Scene
		vertDisplay = new VBox();
		vertDisplay.setSpacing(20);

		sc.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
				Number oldVal, Number newVal) {
				vertDisplay.setLayoutY(-newVal.doubleValue());
			}
		});

		root.getChildren().addAll(vertDisplay, sc);
		// Page Title
		Label pageTitle = new Label("Add Recipe");

		/* Recipe Name Label and Text Field */
		nameSection = new VBox();
		nameSection.setSpacing(10);
		Label nameLabel = new Label("Name:");
		nameTextField = new TextField();
		nameTextField.setPromptText("Recipe Name");
		nameSection.getChildren().addAll(nameLabel, nameTextField);

		/* Recipe Description Label and Text Field */
		descriptionSection = new VBox();
		descriptionSection.setSpacing(10);
		Label descriptionLabel = new Label("Description:");
		descriptionTextField = new TextField();
		descriptionTextField.setPromptText("Description of recipe");
		descriptionSection.getChildren().addAll(descriptionLabel, descriptionTextField);

		/* Recipe Ingredients Label and Text Field*/
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
		addIngredientButton.setOnAction(e -> buttonClicked(e));
		// Create TextField Arrays and add to them
		quantityTextFieldList = new ArrayList<>();
		unitComboBoxList = new ArrayList<>();
		ingredientNameTextFieldList = new ArrayList<>();
		quantityTextFieldList.add(quantityTextField);
		unitComboBoxList.add(unitComboBox);
		ingredientNameTextFieldList.add(ingredientTextField);

		/* Recipe Directions Label and Text Field ***/
		directionVbox = new VBox();
		directionVbox.setSpacing(10);
		Label directionLabel = new Label("Directions");
		TextField directionsTextField = new TextField();
		directionsTextField.setPromptText("Enter Step " + stepCount);
		// Initialize TextField ArrayList and add first item
		instructionTextFieldList = new ArrayList<>();
		instructionTextFieldList.add(directionsTextField);
		directionVbox.getChildren().addAll(directionLabel, directionsTextField);
		// Add More Steps Button and Action
		addStepButton = new Button("Add Additional Step");
		addStepButton.setOnAction(e -> buttonClicked(e));

		// Add Recipe Button
		addRecipe = new Button("Add Recipe");
		addRecipe.setOnAction(e -> buttonClicked(e));

		//Add Recipe Button Status
		addRecipeStatus = new HBox();
		fieldError = new Label("Blank Text Fields or Invalid Number Format of an Ingredient's Quantity");
		fieldError.setTextFill(Color.web("#cc0000"));
		recipeAdded = new Label("Successfully added Recipe!");
		recipeAdded.setTextFill(Color.web("#006b3c"));

		// Add all sections to Scene's VBox
		vertDisplay.getChildren().addAll(NavigationBar.getNavigateBox(), pageTitle, nameSection, descriptionSection,
			ingredientVbox, addIngredientButton, directionVbox, addStepButton, addRecipe, addRecipeStatus);




		// Set screen size
		return new Scene(root, 400, 400);
	}

	@SuppressWarnings("unchecked")
	 private static void buttonClicked(ActionEvent e) {
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
		} else if (e.getSource() == addStepButton) {
			stepCount++;
			TextField directionsTextField = new TextField();
			directionsTextField.setPromptText("Enter Step " + stepCount);
			instructionTextFieldList.add(directionsTextField);
			directionVbox.getChildren().addAll(directionsTextField);
		} else if (e.getSource() == addRecipe) {
			//Invalid text fields, display error message
			if (!validFieldCheck()) {
				if(!previousError) {
					addRecipeStatus.getChildren().add(fieldError);
					previousError = true;
				}
				return;
			}
			//If there was an error before, but not anymore clear the error message
			if(previousError) {
				addRecipeStatus.getChildren().clear();
				previousError = false;
			}
			//Display success message
			if(!previousError) {
				addRecipeStatus.getChildren().add(recipeAdded);
			}
			vertDisplay.getChildren().add(addRecipeStatus);

			transferDirectionList();
			transferIngredientList();

			String name = nameTextField.getText();
			String description = descriptionTextField.getText();
			Recipe addedRecipe = new Recipe(name, description, ingredientList, instructionList);
			Database.saveRecipeToList(addedRecipe);
			try {
				Database.writeRecipeListToFile(addedRecipe);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	private static boolean validFieldCheck() {
		for (int i = 0; i < quantityTextFieldList.size(); i++) {
			if (nameTextField.getText().equals("") || quantityTextFieldList.get(i).getText().equals("")
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

	private static void transferDirectionList() {
		for (TextField i : instructionTextFieldList) {
			instructionList.add(i.getText());
		}
	}

	private static void transferIngredientList() {
		for (int i = 0; i < quantityTextFieldList.size(); i++) {
			ingredientList.add(getIngredient(Integer.parseInt(quantityTextFieldList.get(i).getText()),
				unitComboBoxList.get(i).getValue().toString(), ingredientNameTextFieldList.get(i).getText()));
		}
	}

	private static Ingredient getIngredient(int quantity, String unit, String ingredientName) {
		return new Ingredient(quantity, unit, ingredientName);
	}
}
