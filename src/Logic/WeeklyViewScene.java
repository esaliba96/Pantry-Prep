package Logic;

import java.util.ArrayList;
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
		VBox mealSlots = new VBox();
		for (int i = 0; i < 3; i++){
			MealSlotButton msb = new MealSlotButton(c,uf,i);
			mealSlots.getChildren().add(msb.mealSlotButton);
		}
		//For display testing. Delete later
		//====================================================
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		
		Ingredient i1 = new Ingredient("Saffron", "1Tbsp");
		Ingredient i2 = new Ingredient("Eggs", "2");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		Ingredient i3 = new Ingredient("Beff", "1Tbsp");
		Ingredient i4 = new Ingredient("Corn", "2");
		ArrayList<Ingredient> iList1 = new ArrayList<Ingredient>();
		ArrayList<String> sList1 = new ArrayList<String>();
		sList1.add("Step 1");
		sList1.add("Step 2");
		sList1.add("Step 3");
		iList1.add(i1);
		iList1.add(i2);
		
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", 
				iList, sList);
		
		Recipe r2 = new Recipe("Beef Corn", "Corn with beeff", 
				iList1, sList1);
		
		recipeList.add(r1);
		recipeList.add(r2);
		//====================================================
		
		RecipeScrollPane rsp = new RecipeScrollPane(recipeList);
		recipeLayer.getChildren().addAll(mealSlots,rsp.sp);
		root.getChildren().add(recipeLayer);
		return new Scene(root,400,400);
	}
}
