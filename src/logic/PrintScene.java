package logic;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrintScene {

   private PrintScene() {
   }

   public static Scene getScene(MyCalendar c) {
      UpdateFrame uf = new UpdateFrame();
      HBox switchDayLayer = new HBox();
      VBox begBox = new VBox();
      VBox vertDisplay = new VBox();
      vertDisplay.setSpacing(20);

      HBox begButtonBox = new HBox();
      begBox.getChildren().add(new Label("From:"));
      begBox.getChildren().add(begButtonBox);
      VBox endBox = new VBox();
      HBox endButtonBox = new HBox();
      endBox.getChildren().add(new Label("To: "));
      endBox.getChildren().add(endButtonBox);
      Button begPrev = new Button("<-");
      Double sceneWidth = PantryPrep.stage.getWidth();
      Double sceneHeight = PantryPrep.stage.getHeight();

      ScrollBar sc = new ScrollBar();
      sc.setLayoutX(sceneWidth - sc.getWidth() + 3);
      sc.setMin(0);
      sc.setOrientation(Orientation.VERTICAL);
      sc.setPrefHeight(sceneHeight * 2);
      sc.setMax(1200);

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
      Button printButton = new Button("Print");
      printButton.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            c.pi.printRecipes();
         }
      });
      begButtonBox.getChildren().addAll(begPrev, begDayView.dayView, begNext);
      endButtonBox.getChildren().addAll(endPrev, endDayView.dayView, endNext);
      switchDayLayer.getChildren().addAll(begBox, endBox);

      VBox root = new VBox();
      root.getChildren().add(NavigationBar.getNavigateBox());
      root.getChildren().add(new Label("Print Shopping List"));
      root.getChildren().add(switchDayLayer);
      root.getChildren().add(printButton);

      vertDisplay.getChildren().addAll(root, sc);

      sc.valueProperty().addListener(new ChangeListener<Number>() {
         public void changed(ObservableValue<? extends Number> ov,
             Number oldValue, Number newValue) {
            root.setLayoutY(-newValue.doubleValue());
         }
      });

      return new Scene(vertDisplay, 400, 400);
   }
}
