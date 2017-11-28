package logic;

import java.io.IOException;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class WeeklyViewScene extends Scene {

   private UpdateFrame uf;
   private MyCalendar c;

   // GUI elements
   private MonthLabel monthLabel;
   private SwitchWeeksButton prevWeek;
   private SwitchWeeksButton nextWeek;

   private List<Recipe> recipeList;
   private MealSlotButton[] meals;

   public WeeklyViewScene(MyCalendar myCal) {
      // Dummy root
      super(new Group());

      uf = new UpdateFrame();
      c = myCal;

      // Create root and navigation bar
      VBox root = new VBox();
      root.getChildren().add(NavigationBar.getNavigateBox());

      // Month label
      monthLabel = new MonthLabel(c, uf);
      root.getChildren().add(monthLabel.label);

      // Day Layer
      prevWeek = new SwitchWeeksButton(-1, c, "<-", uf);
      nextWeek = new SwitchWeeksButton(1, c, "->", uf);
      HBox dayLayer = new HBox();
      dayLayer.getChildren().add(prevWeek.switchButton);
      for (int i = 0; i < 7; i++) {
         DayButton dayB = new DayButton(c.getWeek().getDay(i), c, uf);
         dayLayer.getChildren().add(dayB.button);
      }
      dayLayer.getChildren().add(nextWeek.switchButton);
      root.getChildren().add(dayLayer);

      // Meal Slots and Recipe List
      recipeList = Database.getRecipeList();
      meals = new MealSlotButton[3];
      Region spacer1 = new Region();
      Region spacer2 = new Region();
      spacer1.setMinHeight(30);
      spacer2.setMinHeight(30);
      Label recipeListLabel = new Label("Recipe List");
      VBox recipeLayer = new VBox();
      VBox mealSlots = new VBox();
      for (int i = 0; i < 3; i++) {
         MealSlotButton msb = new MealSlotButton(c, uf, i);
         HBox mealSlot = new HBox();

         if (i == 0) {
            mealSlot.getChildren().add(new Label("Breakfast: "));
         } else if (i == 1) {
            mealSlot.getChildren().add(new Label("Lunch: "));
         } else if (i == 2) {
            mealSlot.getChildren().add(new Label("Dinner: "));
         } else {
            mealSlot.getChildren().add(new Label("Other: "));
         }
         mealSlot.getChildren().add(msb.text);
         mealSlots.getChildren().add(mealSlot);
         RecipeScrollPane rsp = new RecipeScrollPane(recipeList, msb);
         if (i == 2) {
            recipeLayer.getChildren().add(rsp.sp);
         }
         meals[i] = msb;
      }
      root.getChildren().addAll(spacer1, mealSlots, spacer2, recipeListLabel, recipeLayer);

      // Save Button
      Button saveButton = new Button("Save");
      saveButton.setOnAction(e -> {
         Day day = new Day();
         for (MealSlotButton msb : meals) {
            String recipeName = msb.text.getText();
            day.setRecipe(msb.getMeal(), Database.getRecipeFromList(recipeName));
         }
         Database.saveMealsToPlanner(c.selectedDay, day);
         try {
            Database.writePlannerToFile();
         } catch (IOException e1) {
            return;
         }
      });

      root.getChildren().add(saveButton);
      setRoot(root);
   }
}
