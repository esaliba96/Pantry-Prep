package Logic;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Calendar;

public class NavigationBar {
	
	static HBox navigate;
	static Button menuButton, calendarButton, createRecipeButton, exitButton;
	
	public static void main (MyCalendar myCal, Stage stage)
	{
		menuButton = new Button("Menu");
		calendarButton = new Button("Calendar");
		createRecipeButton = new Button("Create Recipe");
		exitButton = new Button("Exit");
		navigate = new HBox(8);
		navigate.getChildren().addAll(menuButton, calendarButton, createRecipeButton, exitButton);
		
		//Define Actions for Buttons
		menuButton.setOnAction(e-> ButtonClicked(stage, myCal, e));
		calendarButton.setOnAction(e-> ButtonClicked(stage, myCal, e));
        createRecipeButton.setOnAction(e-> ButtonClicked(stage, myCal, e));
	}
	
	static public void ButtonClicked(Stage stage, MyCalendar myCal, ActionEvent e)
    {
        if (e.getSource()==createRecipeButton)
        {
            stage.setScene(AddRecipeScene.getScene(myCal));
        }
        else if(e.getSource()==menuButton)
        {
            stage.setScene(MenuScene.getScene(myCal));
        }
        else if(e.getSource()==calendarButton)
        {
        		stage.setScene(WeeklyViewScene.getScene(myCal));
        }
    }
	
	static public HBox getNavigateBox()
	{
		return navigate;
	}
	
}
