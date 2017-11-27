package logic;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class WeeklyViewScene extends Scene {

	private UpdateFrame uf;
	private MyCalendar c;
	
	// GUI elements
	private MonthLabel monthLabel;
	private SwitchWeeksButton prevWeek, nextWeek;
	
	private ArrayList<Recipe> recipeList;
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
		root.getChildren().add(monthLabel.monthLabel);

		// Day Layer
		prevWeek = new SwitchWeeksButton(-1, c, "<-", uf);
		nextWeek = new SwitchWeeksButton(1, c, "->", uf);
		HBox dayLayer = new HBox();
		dayLayer.getChildren().add(prevWeek.switchButton);
		for (int i = 0; i < 7; i++) {
			DayButton dayB = new DayButton(c.getWeek().getDay(i), c, uf);
			dayLayer.getChildren().add(dayB.dayButton);
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
			
			if(i == 0){
				mealSlot.getChildren().add(new Label("Breakfast: "));
			}
			else if(i == 1){
				mealSlot.getChildren().add(new Label("Lunch: "));
			}
			else if(i == 2){
				mealSlot.getChildren().add(new Label("Dinner: "));
			}
			else{
				mealSlot.getChildren().add(new Label("Other: "));
			}
			mealSlot.getChildren().add(msb.mealSlotButton);
			mealSlots.getChildren().add(mealSlot);
			RecipeScrollPane rsp = new RecipeScrollPane(recipeList, msb);
			if (i == 2)
				recipeLayer.getChildren().add(rsp.sp);
			meals[i] = msb;
		}
		root.getChildren().addAll(spacer1, mealSlots, spacer2, recipeListLabel, recipeLayer);

		// Save Button
		Button saveButton = new Button("Save");
		saveButton.setOnAction(e -> {
			Day day = new Day();
			for (MealSlotButton msb : meals) {
				String recipeName = msb.mealSlotButton.getText();
				day.setRecipe(msb.getMeal(), Database.getRecipeFromList(recipeName));
			}
			Database.saveMealsToPlanner(c.selectedDay, day);
			try {
				Database.writePlannerToFile();
				System.err.println("Saved");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		root.getChildren().add(saveButton);
		setRoot(root);
	}
	
	private ArrayList<Recipe> getDummyRecipeList() {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);

		Ingredient i3 = new Ingredient(1, "Tbsp", "Beff");
		Ingredient i4 = new Ingredient(2, "husks", "Corn");
		ArrayList<Ingredient> iList1 = new ArrayList<Ingredient>();
		ArrayList<String> sList1 = new ArrayList<String>();
		sList1.add("Step 1");
		sList1.add("Step 2");
		sList1.add("Step 3");
		iList1.add(i3);
		iList1.add(i4);

		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", iList, sList);

		Recipe r2 = new Recipe("Beef Corn", "Corn with beeff", iList1, sList1);

		recipeList.add(r1);
		recipeList.add(r2);
		
		return recipeList;
	}
}
