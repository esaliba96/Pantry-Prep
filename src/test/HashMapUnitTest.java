// Person in charge: Kartik Mendiratta
// 2 Unit Tests

package test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import logic.Database;
import logic.Day;
import logic.Ingredient;
import logic.Recipe;

public class HashMapUnitTest {
	
	@Test
	public void TestRecipeHashMap() {
		Recipe input, output;
		
		// Create a Recipe Object
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "Individual", "Eggs");
		iList.add(i1);
		iList.add(i2);
		
		ArrayList<String> sList = new ArrayList<String>();
		String s1 = "Step 1";
		String s2 = "Step 2";
		String s3 = "Step 3";
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		
		String name = "KartikUnitTestRecipe1";
		String description = "A saffron eggs recipe";
		
		input = new Recipe(name, description, iList, sList);
		Database.saveRecipeToList(input);
		output = Database.getRecipeFromList(name);
		
		assertNotNull(output);
	}
	
	@Test
	public void TestPlannerHashMap() {
		Calendar calendar = Calendar.getInstance();
		Recipe[] inputRecipes = new Recipe[3];
		Day inputDay = new Day();
		Day outputDay;
		
		for (int i = 0; i < 3; i++) {
			ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
			Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
			Ingredient i2 = new Ingredient(2, "Individual", "Eggs");
			iList.add(i1);
			iList.add(i2);
			
			ArrayList<String> sList = new ArrayList<String>();
			String s1 = "Step 1";
			String s2 = "Step 2";
			String s3 = "Step 3";
			sList.add(s1);
			sList.add(s2);
			sList.add(s3);
			
			String name = "KartikUnitTestRecipe2_" + i;
			String description = "A saffron eggs recipe";
			
			inputRecipes[i] = new Recipe(name, description, iList, sList);
			inputDay.setRecipe(i, inputRecipes[i]);
		}
		
		Database.saveMealsToPlanner(calendar, inputDay);
		outputDay = Database.getMealsFromPlanner(calendar);
		assertNotNull(outputDay);
	}
}
