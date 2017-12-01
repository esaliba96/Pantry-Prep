package logic;


import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitButton {
	
	Button recipeButton;
	public ExitButton(Stage s){
		recipeButton = new Button("Exit");
		recipeButton.setOnAction(event -> s.close());
	}
}
