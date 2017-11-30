package logic;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NavigationBar {

   static HBox navigate;
   static Button menuButton;
   static Button calendarButton;
   static Button createRecipeButton;
   static Button exitButton;
   static Button printButton;
   static Button myIngredientsButton;

   private NavigationBar() {
   }

   public static void main(MyCalendar myCal, Stage stage) {
      menuButton = new Button("About");
      calendarButton = new Button("Calendar");
      createRecipeButton = new Button("Create Recipe");
      myIngredientsButton = new Button("My Ingredients");
      printButton = new Button("Shopping List");
      exitButton = new Button("Exit");
      navigate = new HBox(8);
      navigate.getChildren()
          .addAll(menuButton, calendarButton, createRecipeButton, myIngredientsButton, printButton,
              exitButton);

      //Define Actions for Buttons
      menuButton.setOnAction(e -> buttonClicked(stage, myCal, e));
      printButton.setOnAction(e -> buttonClicked(stage, myCal, e));
      calendarButton.setOnAction(e -> buttonClicked(stage, myCal, e));
      createRecipeButton.setOnAction(e -> buttonClicked(stage, myCal, e));
      myIngredientsButton.setOnAction(e -> buttonClicked(stage, myCal, e));
      exitButton.setOnAction(e -> buttonClicked(stage, myCal, e));
   }

   public static void buttonClicked(Stage stage, MyCalendar myCal, ActionEvent e) {
      if (e.getSource() == createRecipeButton) {
         stage.setScene(AddRecipeScene.getScene());
      } else if (e.getSource() == printButton) {
         stage.setScene(PrintScene.getScene(myCal));
      } else if (e.getSource() == menuButton) {
         stage.setScene(MenuScene.getScene());
      } else if (e.getSource() == calendarButton) {
         stage.setScene(new WeeklyViewScene(myCal));
      } else if (e.getSource() == myIngredientsButton) {
         stage.setScene(MyIngredientScene.getScene());
      } else if (e.getSource() == exitButton) {
         Platform.exit();
      }
   }

   public static HBox getNavigateBox() {
      return navigate;
   }
}
