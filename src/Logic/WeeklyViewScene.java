package Logic;

import java.util.Calendar;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WeeklyViewScene {
	public static Scene getScene(MyCalendar c){
		UpdateFrame uf = new UpdateFrame();
		VBox root = new VBox();
		MonthLabel monthLabel = new MonthLabel(c,uf);
		root.getChildren().add(monthLabel.monthLabel);
		HBox dayLayer = new HBox();
		dayLayer.getChildren().add(new SwitchWeeksButton(-1,c,"<-",uf).switchButton);
		for (int i = 0; i < 7; i++){
			DayButton dayB = new DayButton(c.getWeek().getDay(i),c,uf);
			dayLayer.getChildren().add(dayB.dayButton);
		}
		dayLayer.getChildren().add(new SwitchWeeksButton(1,c,"->",uf).switchButton);
		root.getChildren().add(dayLayer);
		HBox recipeLayer = new HBox();
		RecipeScrollPane rsp = new RecipeScrollPane("trevor put arraylist here");
		recipeLayer.getChildren().add(rsp.sp);
		root.getChildren().add(recipeLayer);
		return new Scene(root,400,400);
	}
}
