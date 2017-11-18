package Logic;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrintScene {
	public static Scene getScene(MyCalendar c){
		UpdateFrame uf = new UpdateFrame();
		HBox switchDayLayer = new HBox();
		SwitchDayButton begPrev = new SwitchDayButton(-1,true,false,"<-",uf,c);
		DayViewLabel begDayView = new DayViewLabel(uf,c,false);
		SwitchDayButton begNext = new SwitchDayButton(1,false,false,"->",uf,c);
		SwitchDayButton endPrev = new SwitchDayButton(-11,true,true,"<-",uf,c);
		DayViewLabel endDayView = new DayViewLabel(uf,c,true);
		SwitchDayButton endNext = new SwitchDayButton(1,false,true,"->",uf,c);
		switchDayLayer.getChildren().addAll(begPrev.switchButton,begDayView.dayView,begNext.switchButton,endPrev.switchButton,endDayView.dayView,endNext.switchButton);
		VBox root = new VBox();
		root.getChildren().add(switchDayLayer);
		return new Scene(root,400,400);
	}
}
