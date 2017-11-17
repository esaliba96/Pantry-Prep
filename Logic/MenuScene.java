package Logic;

import java.util.Calendar;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MenuScene {
	public static Scene getScene(MyCalendar c){
		//Sets up ButtonFactory arrayList
		//UpdateFrame uf = new UpdateFrame();
		
		//Vbox creates a vertical column
		VBox menuDisplay = new VBox();
		//Creates and adds Month to Vbox
		Label menuLabel = new Label("Pantry Prep is Awesome");
		if(NavigationBar.getNavigateBox() == null)
		{
			System.out.println("true");
		}
		menuDisplay.getChildren().add(NavigationBar.getNavigateBox());
		menuDisplay.getChildren().add(menuLabel);
	
		//Add root Vbox to the center of the Border Pane
		//border.setCenter(menuDisplay);
		
		//Set screen size?
		return new Scene(menuDisplay,400,400);
	}
}