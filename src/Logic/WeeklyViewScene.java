package Logic;

import java.util.Calendar;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WeeklyViewScene {
	public static Scene getScene(MyCalendar c){
		VBox root = new VBox(); 
		HBox dayLayer = new HBox();
		dayLayer.getChildren().add(new SwitchWeeksButton(-1,c,"<-").switchButton);
		UpdateFrame uf = new UpdateFrame();
		for (int i = 0; i < 7; i++){
			DayButton dayB = new DayButton(c.getWeek().getDay(i),c,uf);
			dayLayer.getChildren().add(dayB.dayButton);
		}
		dayLayer.getChildren().add(new SwitchWeeksButton(1,c,"->").switchButton);
		root.getChildren().add(dayLayer);
		return new Scene(root,400,400);
	}
}
