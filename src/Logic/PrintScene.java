package Logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrintScene {
	public static Scene getScene(MyCalendar c){
		UpdateFrame uf = new UpdateFrame();
		HBox switchDayLayer = new HBox();
		VBox begBox = new VBox();
		HBox begButtonBox = new HBox();
		begBox.getChildren().add(new Label("From:"));
		begBox.getChildren().add(begButtonBox);
		VBox endBox = new VBox();
		HBox endButtonBox = new HBox();
		endBox.getChildren().add(new Label("To: "));
		endBox.getChildren().add(endButtonBox);
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
		Button printButton = new Button("Print");
		printButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				c.pi.printRecipes(c);
			}
		});
		begButtonBox.getChildren().addAll(begPrev,begDayView.dayView,begNext);
		endButtonBox.getChildren().addAll(endPrev,endDayView.dayView,endNext);
		switchDayLayer.getChildren().addAll(begBox,endBox);
		VBox root = new VBox();
		root.getChildren().add(new Label("Print Shopping List"));
		root.getChildren().add(switchDayLayer);
		root.getChildren().add(printButton);
		return new Scene(root,400,400);
	}
}
