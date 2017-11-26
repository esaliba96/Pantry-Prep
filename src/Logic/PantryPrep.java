package Logic;

import java.util.ArrayList;
import java.util.Calendar;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Priority;

public class PantryPrep extends Application{
	private MyCalendar myCal;
	private BorderPane border;
	private Scene menuScene, addRecipeScene, weeklyViewScene;
			
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		/* Load saved data, if any */
		Database.readRecipesFromFile();
		Database.readPlannerFromFile();
		
		myCal = new MyCalendar(Calendar.getInstance());
		
		//Application Title
		stage.setTitle("PantryPrep");	
		
		NavigationBar.main(myCal, stage);
		menuScene = MenuScene.getScene(myCal);
		addRecipeScene = AddRecipeScene.getScene(myCal);
		weeklyViewScene = WeeklyViewScene.WeeklyViewScene(myCal);
		
		stage.setScene(weeklyViewScene);
		stage.setWidth(575);
		stage.setHeight(600);
		
		stage.show();
		
        /*
        //Code to show the add ingredient page.
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		ArrayList<String> instructions = new ArrayList<String>();
		Recipe recipe = new Recipe("recipe name", "Your recipe description.", ingredients, instructions);
		stage.setTitle("PantryPrepXX");
		stage.setScene(AddIngredientScene.getScene(recipe));
		stage.show();
         */
		
		/*
		//Code to test recipe scene
		
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<MealSlotButton> meals = new ArrayList<>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", iList, sList);

		stage.setTitle("PantryPrepXX");
		stage.setScene(RecipeViewScene.getScene(r1));
		stage.show();
		*/
		 
		 
		 
	}
}
