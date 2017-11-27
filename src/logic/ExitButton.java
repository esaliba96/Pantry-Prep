package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitButton {
	
	Button recipeButton;
	public ExitButton(Stage s){
		recipeButton = new Button("Exit");
		recipeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				s.close();
			}
		});
	}
}
