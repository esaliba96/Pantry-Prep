package logic;

import javafx.scene.text.Text;

public class MealSlotButton implements ButtonFactory{
	Text text;
	private int meal;
	private Recipe recipe;

	//meal 0 = breakfast 1 = lunch 2 = dinner
	public MealSlotButton(MyCalendar c, UpdateFrame uf,int mealNum){
		this.meal = mealNum;
		uf.addFactory(this);
		text = new Text();
		this.recipe = null;
		
		
		//Clickable Calendar (Under construction)
		//===============================================================
		

		
		
		text.setOnMouseClicked(event -> {
         Day day = Database.getMealsFromPlanner(c.selectedDay);

         if (day != null) {
            recipe = day.getRecipe(meal);
            
            if(recipe != null){
                 PantryPrep.stage.setScene(RecipeViewScene.getScene(recipe));
             }
         }
         event.consume();
      });
		//===============================================================
		write(c);		
	}
	
	public void write(MyCalendar c) {
		Day day = Database.getMealsFromPlanner(c.selectedDay);
		
		if (day == null) {
			text.setText("Unplanned");
			return;
		}
		
		recipe = day.getRecipe(meal);

		if (recipe == null) {
			text.setText("Unplanned");
		} else {
			text.setText(recipe.getName());
		}
	}
	
	public int getMeal() {
		return this.meal;
	}

}
