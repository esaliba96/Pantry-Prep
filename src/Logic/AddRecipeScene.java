package Logic;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
import java.util.Calendar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Priority;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.application.Application;

public class AddRecipeScene {

	static VBox nameSection, descriptionSection, ingredientVbox, directionVbox;
	static Button addIngredientButton, addStepButton, addRecipe;
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

	public static Scene getScene(MyCalendar c) {
		// ScrollPane sp = new ScrollPane();

		// VBox for whole Add Recipe Scene
		VBox vertDisplay = new VBox();
		vertDisplay.setSpacing(20);

		// Page Title
		Label pageTitle = new Label("Add Recipe");

		/*** Recipe Name Label and Text Field ***/
		nameSection = new VBox();
		nameSection.setSpacing(10);
		Label nameLabel = new Label("Name:");
		nameTextField = new TextField();
		nameTextField.setPromptText("Recipe Name");
		nameSection.getChildren().addAll(nameLabel, nameTextField);

		/*** Recipe Description Label and Text Field ***/
		descriptionSection = new VBox();
		descriptionSection.setSpacing(10);
		Label descriptionLabel = new Label("Description:");
		descriptionTextField = new TextField();
		descriptionTextField.setPromptText("Description of recipe");
		descriptionSection.getChildren().addAll(descriptionLabel, descriptionTextField);

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

		/*** Recipe Directions Label and Text Field ***/
		directionVbox = new VBox();
		directionVbox.setSpacing(10);
		Label directionLabel = new Label("Directions");
		TextField directionsTextField = new TextField();
		directionsTextField.setPromptText("Enter Step " + stepCount);
		// Initialize TextField ArrayList and add first item
		instructionTextFieldList = new ArrayList<TextField>();
		instructionTextFieldList.add(directionsTextField);
		directionVbox.getChildren().addAll(directionLabel, directionsTextField);
		// Add More Steps Button and Action
		addStepButton = new Button("Add Additional Step");
		addStepButton.setOnAction(e -> ButtonClicked(e));

		// Add Recipe Button
		addRecipe = new Button("Add Recipe");
		addRecipe.setOnAction(e -> ButtonClicked(e));

		// Add all sections to Scene's VBox
		vertDisplay.getChildren().addAll(NavigationBar.getNavigateBox(), pageTitle, nameSection, descriptionSection,
				ingredientVbox, addIngredientButton, directionVbox, addStepButton, addRecipe);

		// Set screen size
		return new Scene(vertDisplay, 400, 400);
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
		} else if (e.getSource() == addStepButton) {
			stepCount++;
			TextField directionsTextField = new TextField();
			directionsTextField.setPromptText("Enter Step " + stepCount);
			instructionTextFieldList.add(directionsTextField);
			directionVbox.getChildren().addAll(directionsTextField);
			System.out.println("yeeee");
		} else if (e.getSource() == addRecipe) {
			if (validFieldCheck() == false) {
				System.out.println("Invalid Text Fields");
				return;
			}
			transferDirectionList();
			transferIngredientList();
			for (int i = 0; i < ingredientList.size(); i++) {
				System.out.println("this: " + ingredientList.get(i).getQuantity());
				System.out.println("this2: " + ingredientList.get(i).getUnit());
				System.out.println("this3: " + ingredientList.get(i).getIngredientName());
			}

			String name = nameTextField.getText();
			String description = descriptionTextField.getText();
			Recipe addedRecipe = new Recipe(name, description, ingredientList, instructionList);
			Database.saveRecipeToList(addedRecipe);
			try {
				Database.writeRecipeListToFile(addedRecipe);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	static public boolean validFieldCheck() {
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

	static public void transferDirectionList() {
		for (int i = 0; i < instructionTextFieldList.size(); i++) {
			instructionList.add(instructionTextFieldList.get(i).getText());
		}
		for (int i = 0; i < instructionList.size(); i++) {
			System.out.println(instructionList.get(i));
		}
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
