package Logic;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DayButton implements ButtonFactory {
	Button dayButton;
	private int dayOfWeek;
	public DayButton(Calendar day, MyCalendar c,UpdateFrame uf){
		dayButton = new Button("" + day.get(Calendar.DAY_OF_MONTH));
		this.dayOfWeek = day.get(Calendar.DAY_OF_WEEK);
		uf.addFactory(this);
		write(c);
		dayButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.selectedDay = c.getWeek().getDay(dayOfWeek -1);
				uf.update(c);
			} 
		});
	}
	public void write(MyCalendar c){
		Calendar day = c.getWeek().getDay(dayOfWeek -1);
		String buttonText = CalendarUtil.numWeekToString(day.get(Calendar.DAY_OF_WEEK)-1);
		buttonText += ("\n" + day.get(Calendar.DAY_OF_MONTH));
		dayButton.setText(buttonText);
		if (CalendarUtil.compareDates(c.currentDay, c.selectedDay) && c.selectedDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#ff00ff");
		}
		else if (c.selectedDay.equals(day)){
			dayButton.setStyle("-fx-background-color:#ff0000");
		}
		else if (CalendarUtil.compareDates(day, c.currentDay)){
			dayButton.setStyle("-fx-background-color:#0000ff");
		}
		else {
			dayButton.setStyle("-fx-background-color:#00ff00");
		}
	}
}
