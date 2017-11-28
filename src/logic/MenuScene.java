package logic;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class MenuScene {
   private MenuScene(){}
	public static Scene getScene(){
		//Sets up ButtonFactory arrayList

		//Vbox creates a vertical column
		VBox menuDisplay = new VBox();
		//Creates and adds Month to Vbox
		Label menuLabel = new Label("Welcome to Pantry Prep!");
		Label descriptionLabel = new Label("Click any of the options above to get started "
				+ "on your path to being a healthier person.");

		menuDisplay.getChildren().add(NavigationBar.getNavigateBox());
		menuDisplay.getChildren().add(menuLabel);
		menuDisplay.getChildren().add(descriptionLabel);
	
		//Add root Vbox to the center of the Border Pane
		//Set screen size?
		return new Scene(menuDisplay,400,400);
	}
}
