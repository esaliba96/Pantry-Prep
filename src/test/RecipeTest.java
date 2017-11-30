package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.Ingredient;
import logic.Recipe;

public class RecipeTest {

	@Test
	public void testName() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", 
				iList, sList);
		
		assertEquals("Saffron Eggs", r1.getName());
		assertNotEquals("Saffron Megs", r1.getName());
		assertNotEquals("", r1.getName());
		
		
	}
	
	@Test
	public void testDescription() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", 
				iList, sList);
		
		assertEquals("A saffron eggs recipe", r1.getDescription());
		assertNotEquals("Saffron Megs", r1.getDescription());
		assertNotEquals("", r1.getDescription());
		
		
	}
	
	@Test
	public void testIngredientList() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", 
				iList, sList);
		
		
		ArrayList<Ingredient> testList = (ArrayList<Ingredient>)r1.getIngredientList();
		Ingredient i3 = testList.get(0);
		Ingredient i4 = testList.get(1);
		assertEquals(2, testList.size());
		
		assertEquals("Tbsp", i3.getUnit());
		assertEquals("(Eggs)", i4.getUnit());
		assertEquals(1, i3.getQuantity());
		assertEquals(2, i4.getQuantity());
		assertEquals("Saffron", i3.getIngredientName());
		assertEquals("Eggs", i4.getIngredientName());
		
	}
	
	@Test
	public void testInstructionList() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", 
				iList, sList);
		
		ArrayList<String> testList = (ArrayList<String>)r1.getInstructionList();
		assertEquals(3, testList.size());
		assertEquals("Step 1",testList.get(0));
		assertEquals("Step 2",testList.get(1));
		assertEquals("Step 3",testList.get(2));
		
	}
	

}