package Logic;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MealSlotButton implements ButtonFactory{
	public Button mealSlotButton;
	private int meal;
	//meal 0 = breakfast 1 = lunch 2 = dinner
	public MealSlotButton(MyCalendar c, UpdateFrame uf,int meal){
		this.meal = meal;
		uf.addFactory(this);
		mealSlotButton = new Button("empty");
		write(c);
		mealSlotButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
			} 
		});
	}
	public void write(MyCalendar c) {
		int dayOfWeek = c.selectedDay.get(Calendar.DAY_OF_WEEK);
		Day day = c.getWeek().getDayRecipes(dayOfWeek -1);
		mealSlotButton.setText("meal for " + c.selectedDay.get(Calendar.DAY_OF_MONTH));
	}

}
