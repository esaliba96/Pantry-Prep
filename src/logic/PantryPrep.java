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

   @Override
   public void start(Stage localStage) throws Exception {
      Scene weeklyViewScene;
      MyCalendar myCal;

      stage = localStage;
      /* Load saved data, if any */
      Database.readRecipesFromFile();
      Database.readPlannerFromFile();

      myCal = new MyCalendar(Calendar.getInstance());

      //Application Title
      stage.setTitle("PantryPrep");

      NavigationBar.main(myCal, stage);
      weeklyViewScene = new WeeklyViewScene(myCal);

      stage.setScene(weeklyViewScene);
      stage.setWidth(585);
      stage.setHeight(600);

      stage.show();
   }
}