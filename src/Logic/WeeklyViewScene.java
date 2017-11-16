package Logic;

import java.util.ArrayList;
import java.util.Calendar;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class WeeklyViewScene {
	public static Scene getScene(MyCalendar c){
		//Sets up ButtonFactory arrayList
		UpdateFrame uf = new UpdateFrame();
		
		//Vbox creates a vertical column
		VBox root = new VBox();
		root.getChildren().add(NavigationBar.getNavigateBox());
		//Creates and adds Month to Vbox
		MonthLabel monthLabel = new MonthLabel(c,uf);
		root.getChildren().add(monthLabel.monthLabel);
		//Hbox creates a horizontal row
		HBox dayLayer = new HBox();
		//Add arrow buttons and calendar days to Hbox
		dayLayer.getChildren().add(new SwitchWeeksButton(-1,c,"<-",uf).switchButton);
		for (int i = 0; i < 7; i++){
			DayButton dayB = new DayButton(c.getWeek().getDay(i),c,uf);
			dayLayer.getChildren().add(dayB.dayButton);
		}
		dayLayer.getChildren().add(new SwitchWeeksButton(1,c,"->",uf).switchButton);
		//Adds Hbox to Vbox
		root.getChildren().add(dayLayer);
		//Add root Vbox to the center of the Border Pane
		//border.setCenter(weekDisplay);
		
		//Set screen size?
		//return new Scene(weekDisplay,400,400);

		//root.getChildren().add(dayLayer);
		HBox recipeLayer = new HBox();
		VBox mealSlots = new VBox();
		for (int i = 0; i < 3; i++){
			MealSlotButton msb = new MealSlotButton(c,uf,i);
			mealSlots.getChildren().add(msb.mealSlotButton);
		}
		//For display testing. Delete later
		//====================================================
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
