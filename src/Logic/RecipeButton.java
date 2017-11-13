package Logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RecipeButton {
	
	Button recipeButton;
	public RecipeButton(int offset, MyCalendar c, Recipe r, UpdateFrame uf){
		recipeButton = new Button(r.getName());
		recipeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				
			}
		});
	}
		
}

