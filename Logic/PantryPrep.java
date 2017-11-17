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
	Calendar currentDay;
	MyCalendar myCal;
	BorderPane border;
	Scene menuScene, addRecipeScene, weeklyViewScene;
			
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		    	
		currentDay = Calendar.getInstance();
		myCal = new MyCalendar(currentDay);
		
		//Application Title
		stage.setTitle("PantryPrep");	
		
		NavigationBar.main(myCal, stage);
		menuScene = MenuScene.getScene(myCal);
		addRecipeScene = AddRecipeScene.getScene(myCal);
		weeklyViewScene = WeeklyViewScene.getScene(myCal);
		
		stage.setScene(weeklyViewScene);
		
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
	}
}