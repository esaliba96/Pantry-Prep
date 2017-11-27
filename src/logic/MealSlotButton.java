package logic;

import java.util.Calendar;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class MealSlotButton implements ButtonFactory{
	public Text mealSlotButton;
	private int meal;
	private Recipe recipe;

	//meal 0 = breakfast 1 = lunch 2 = dinner
	public MealSlotButton(MyCalendar c, UpdateFrame uf,int mealNum){
		this.meal = mealNum;
		uf.addFactory(this);
		mealSlotButton = new Text();
		this.recipe = null;
		
		
		//Clickable Calendar (Under construction)
		//===============================================================
		

		
		
		mealSlotButton.setOnMouseClicked(new EventHandler <MouseEvent>(){
        	public void handle(MouseEvent event) {
        		Day day = Database.getMealsFromPlanner(c.selectedDay);

        		if (day != null) {
        			recipe = day.getRecipe(meal);
        			
        			if(recipe != null){
                		PantryPrep.stage.setScene(RecipeViewScene.getScene(recipe));
            		}
        		}
        		event.consume();
        	}
        });
		//===============================================================

		
		write(c);
		
		
		
	}
	
	public void write(MyCalendar c) {
		int dayOfWeek = c.selectedDay.get(Calendar.DAY_OF_WEEK);
		Day day = Database.getMealsFromPlanner(c.selectedDay);
		
		if (day == null) {
			mealSlotButton.setText("Unplanned");
			return;
		}
		
		Recipe recipe = day.getRecipe(meal);
	
		
		if (recipe == null) {
			mealSlotButton.setText("Unplanned");
		} else {
			this.recipe = recipe;
			mealSlotButton.setText(recipe.getName());
		}
	}
	
	public int getMeal() {
		return this.meal;
	}

}
