package Logic;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DayButton {
	Button dayButton;
	public DayButton(Calendar day, MyCalendar c){
		dayButton = new Button("" + day.get(Calendar.DAY_OF_MONTH));
		if (c.currentDay.equals(c.selectedDay) && c.currentDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#ff00ff");
		}
		else if (c.selectedDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#ff0000");
		}
		else if (c.currentDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#0000ff");
		}
		dayButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.selectedDay = day;	
			} 
		});
	}
}
