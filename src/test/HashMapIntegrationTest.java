// Person in charge: Kartik Mendiratta
// 2 Integration Tests

package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import logic.Database;
import logic.Day;
import logic.Ingredient;
import logic.Recipe;

public class HashMapIntegrationTest {
	
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
		
		String name = "KartikIntegrationTestRecipe1";
		String description = "A saffron eggs recipe";
		
		input = new Recipe(name, description, iList, sList);
		
		StringBuilder inputBuilder = new StringBuilder(input.getName());
		inputBuilder.append(input.getDescription());
		
		for (Ingredient i : input.getIngredientList()) {
			inputBuilder.append(i.getQuantity());
			inputBuilder.append(i.getUnit());
			inputBuilder.append(i.getIngredientName());
		}
		
		for (String s : input.getInstructionList()) {
			inputBuilder.append(s);
		}
		
		String inputString = inputBuilder.toString();
		
		Database.saveRecipeToList(input);
		output = Database.getRecipeFromList(name);
			
		StringBuilder outputBuilder = new StringBuilder(output.getName());
		outputBuilder.append(output.getDescription());
		
		for (Ingredient i : output.getIngredientList()) {
			outputBuilder.append(i.getQuantity());
			outputBuilder.append(i.getUnit());
			outputBuilder.append(i.getIngredientName());
		}
		
		for (String s : output.getInstructionList()) {
			outputBuilder.append(s);
		}
		
		String outputString = outputBuilder.toString();
		
		assertEquals(inputString, outputString);
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
			
			String name = "KartikIntegrationTestRecipe2_" + i;
			String description = "A saffron eggs recipe";
			
			inputRecipes[i] = new Recipe(name, description, iList, sList);
			inputDay.setRecipe(i, inputRecipes[i]);
		}
		
		Database.saveMealsToPlanner(calendar, inputDay);
		outputDay = Database.getMealsFromPlanner(calendar);
		
		StringBuilder inputBuilder = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			inputBuilder.append(inputDay.getRecipe(i).getName());
		}
		
		StringBuilder outputBuilder = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			outputBuilder.append(outputDay.getRecipe(i).getName());
		}
		
		assertEquals(inputBuilder.toString(), outputBuilder.toString());
	}
}
