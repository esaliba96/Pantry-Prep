package Logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrintScene {
	public static Scene getScene(MyCalendar c){
		UpdateFrame uf = new UpdateFrame();
		HBox switchDayLayer = new HBox();
		Button begPrev = new Button("<-");
		begPrev.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.pi.beginningPrev();
				uf.update(c);
			}
		});
		Button begNext = new Button("->");
		begNext.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.pi.beginningNext();
				uf.update(c);
			}
		});
		Button endPrev = new Button("<-");
		endPrev.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.pi.endPrev();;
				uf.update(c);
			}
		});
		Button endNext = new Button("->");
		endNext.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.pi.endNext();;
				uf.update(c);
			}
		});
		DayViewLabel begDayView = new DayViewLabel(uf,c,false);
		DayViewLabel endDayView = new DayViewLabel(uf,c,true);
		switchDayLayer.getChildren().addAll(begPrev,begDayView.dayView,begNext,endPrev,endDayView.dayView,endNext);
		VBox root = new VBox();
		root.getChildren().add(switchDayLayer);
		return new Scene(root,400,400);
	}
}
