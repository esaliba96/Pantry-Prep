package logic;

import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PantryPrep extends Application {

	static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	public static void setupStage(Stage s) {
		Scene weeklyViewScene;
		MyCalendar myCal = new MyCalendar(Calendar.getInstance());

		stage = s;

		// Application Title
		stage.setTitle("PantryPrep");

		NavigationBar.main(myCal, stage);
		weeklyViewScene = new WeeklyViewScene(myCal);

		stage.setScene(weeklyViewScene);
		stage.setWidth(585);
		stage.setHeight(600);

		stage.show();
	}

	@Override
	public void start(Stage localStage) throws Exception {

		/* Load saved data, if any */
		Database.readRecipesFromFile();
		Database.readPlannerFromFile();
		
		setupStage(localStage);

	}
}