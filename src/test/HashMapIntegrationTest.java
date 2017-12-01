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
	public void testRecipeHashMap() {
		Recipe output;
		Recipe input;
			
		// Create a Recipe Object
		Ingredient i2 = new Ingredient(2, "Individual", "Eggs");
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		ArrayList<Ingredient> iList = new ArrayList<>();
		iList.add(i1);
		iList.add(i2);
		
		
		String s1 = "Step 1";
		ArrayList<String> sList = new ArrayList<>();
		sList.add(s1);
		String s2 = "Step 2";
		sList.add(s2);
		String s3 = "Step 3";
		sList.add(s3);
		
		String description = "A saffron eggs recipe";
		String name = "KartikIntegrationTestRecipe1";
		
		
		input = new Recipe(name, description, iList, sList);
		
		StringBuilder inputBuilder = new StringBuilder(input.getName());
		
		inputBuilder.append(input.getDescription());
		
		for (Ingredient i : input.getIngredientList()) {
			inputBuilder.append(i.getIngredientName());
			inputBuilder.append(i.getUnit());
			inputBuilder.append(i.getQuantity());		
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
			outputBuilder.append(i.getIngredientName());
			outputBuilder.append(i.getUnit());
			outputBuilder.append(i.getQuantity());
		}
		
		for (String s : output.getInstructionList()) {
			outputBuilder.append(s);
		}
		
		assertEquals(inputString, outputBuilder.toString());
	}
	
	@Test
	public void testPlannerHashMap() {
		Day inputDay = new Day();
		Day outputDay;
		Calendar calendar = Calendar.getInstance();
		Recipe[] inputRecipes = new Recipe[3];
		
		
		for (int i = 0; i < 3; i++) {
			Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
			Ingredient i2 = new Ingredient(2, "Individual", "Eggs");
			ArrayList<Ingredient> iList = new ArrayList<>();			
			iList.add(i1);
			iList.add(i2);
					
			String s3 = "Step 3";
			String s1 = "Step 1";
			String s2 = "Step 2";
			ArrayList<String> sList = new ArrayList<>();
			sList.add(s1);
			sList.add(s2);
			sList.add(s3);
			
			String description = "A saffron eggs recipe";
			String name = "KartikIntegrationTestRecipe2_" + i;
				
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
