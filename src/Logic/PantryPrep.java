package Logic;
import java.util.Calendar;import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class PantryPrep extends Application{
	
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Calendar currentDay = Calendar.getInstance();
		MyCalendar myCal = new MyCalendar(currentDay);
		stage.setTitle("PantryPrep");
		stage.setScene(WeeklyViewScene.getScene(myCal));
		stage.show();
	}
}
