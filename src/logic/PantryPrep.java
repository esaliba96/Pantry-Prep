package logic;

import java.util.Calendar;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;

public class PantryPrep extends Application{
	private MyCalendar myCal;
	private BorderPane border;
	private Scene menuScene, addRecipeScene, weeklyViewScene;
	protected static Stage stage;
			
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage localStage) throws Exception {
		stage = localStage;
		/* Load saved data, if any */
		Database.readRecipesFromFile();
		Database.readPlannerFromFile();
		
		myCal = new MyCalendar(Calendar.getInstance());
		
		//Application Title
		stage.setTitle("PantryPrep");	
		
		NavigationBar.main(myCal, stage);
		menuScene = MenuScene.getScene(myCal);
		addRecipeScene = AddRecipeScene.getScene(myCal);
		weeklyViewScene = new WeeklyViewScene(myCal);
		
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
	}
}