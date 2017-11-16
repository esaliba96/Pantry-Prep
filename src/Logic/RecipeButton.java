package Logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RecipeButton {
	
	Button recipeButton;
	public RecipeButton(Recipe r){
		recipeButton = new Button(r.getName());
		recipeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				
			}
		});
	}
		
}

