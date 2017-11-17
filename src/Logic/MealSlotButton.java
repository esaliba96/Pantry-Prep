package Logic;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MealSlotButton implements ButtonFactory{
	public Text mealSlotButton;
	private int meal;

	//meal 0 = breakfast 1 = lunch 2 = dinner
	public MealSlotButton(MyCalendar c, UpdateFrame uf,int meal){
		this.meal = meal;
		uf.addFactory(this);
		mealSlotButton = new Text();
		write(c);
	}
	public void write(MyCalendar c) {
		int dayOfWeek = c.selectedDay.get(Calendar.DAY_OF_WEEK);
		Day day = c.getWeek().getDayRecipes(dayOfWeek -1);
		mealSlotButton.setText("meal for " + c.selectedDay.get(Calendar.DAY_OF_MONTH));
	}

}
