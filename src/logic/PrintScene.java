package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PrintScene {

	private PrintScene() {
	}

	public static Scene getScene(MyCalendar c) {
		UpdateFrame uf = new UpdateFrame();
		HBox switchDayLayer = new HBox();
		switchDayLayer.setSpacing(50);
		VBox begBox = new VBox();
		HBox begButtonBox = new HBox();
		begButtonBox.setMinHeight(30);
		begButtonBox.setSpacing(20);
		begBox.getChildren().add(new Label("From:"));
		begBox.getChildren().add(begButtonBox);
		VBox endBox = new VBox();
		HBox endButtonBox = new HBox();
		endButtonBox.setMinHeight(30);
		endButtonBox.setSpacing(20);
		endBox.getChildren().add(new Label("To: "));
		endBox.getChildren().add(endButtonBox);
		Button begPrev = new Button("<-");
		Label message = new Label();

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
				c.pi.endPrev();
				uf.update(c);
			}
		});
		Button endNext = new Button("->");
		endNext.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				c.pi.endNext();
				uf.update(c);
			}
		});

		DayViewLabel begDayView = new DayViewLabel(uf, c, false);
		DayViewLabel endDayView = new DayViewLabel(uf, c, true);

		VBox root = new VBox();
		root.getChildren().add(NavigationBar.getNavigateBox());
		root.getChildren().add(new Label("Generate Shopping List"));
		root.getChildren().add(switchDayLayer);

		Button printButton = new Button("Save");
		printButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				message.setTextFill(Color.web("#6b002f"));
				if (!c.pi.validate()) {
					message.setText("Invalid dates!");
				} else if (!c.pi.printRecipes("shopping_list.txt")) {
					message.setText("Unable to save shopping list to file!");
				} else {
					message.setTextFill(Color.web("#006b3c"));
					message.setText("Successfully saved shopping list to file!");
				}
			}
		});

		root.getChildren().add(printButton);
		root.getChildren().add(message);
		root.setSpacing(5);
		begButtonBox.getChildren().addAll(begPrev, begDayView.dayView, begNext);
		endButtonBox.getChildren().addAll(endPrev, endDayView.dayView, endNext);
		switchDayLayer.getChildren().addAll(begBox, endBox);

		return new Scene(root, 400, 400);
	}
}
