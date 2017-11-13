package Logic;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DayButton implements ButtonFactory {
	Button dayButton;
	private int dayOfWeek;
	private Calendar day;
	public DayButton(Calendar day, MyCalendar c,UpdateFrame uf){
		dayButton = new Button("" + day.get(Calendar.DAY_OF_MONTH));
		this.dayOfWeek = day.get(Calendar.DAY_OF_WEEK);
		uf.addFactory(this);
		write(c);
		dayButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.selectedDay = day;
				uf.update(c);
			} 
		});
	}
	public void write(MyCalendar c){
		dayButton.setText("" + c.getWeek().getDay(dayOfWeek).get(Calendar.DAY_OF_MONTH));
		if (c.currentDay.equals(c.selectedDay) && c.currentDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#ff00ff");
		}
		else if (c.selectedDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#ff0000");
		}
		else if (c.currentDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#0000ff");
		}
	}
}
