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

public class WeeklyViewScene {
	public static Scene getScene(MyCalendar c){
		//Sets up ButtonFactory arrayList
		UpdateFrame uf = new UpdateFrame();
		
		//Vbox creates a vertical column
		VBox weekDisplay = new VBox();
		weekDisplay.getChildren().add(NavigationBar.getNavigateBox());
		//Creates and adds Month to Vbox
		MonthLabel monthLabel = new MonthLabel(c,uf);
		weekDisplay.getChildren().add(monthLabel.monthLabel);
		//Hbox creates a horizontal row
		HBox dayLayer = new HBox();
		//Add arrow buttons and calendar days to Hbox
		dayLayer.getChildren().add(new SwitchWeeksButton(-1,c,"<-",uf).switchButton);
		for (int i = 0; i < 7; i++){
			DayButton dayB = new DayButton(c.getWeek().getDay(i),c,uf);
			dayLayer.getChildren().add(dayB.dayButton);
		}
		dayLayer.getChildren().add(new SwitchWeeksButton(1,c,"->",uf).switchButton);
		//Adds Hbox to Vbox
		weekDisplay.getChildren().add(dayLayer);
		//Add root Vbox to the center of the Border Pane
		//border.setCenter(weekDisplay);
		
		//Set screen size?
		return new Scene(weekDisplay,400,400);
	}
}
