package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.Ingredient;
import logic.Recipe;

public class RecipeIngredientIntegrationTest {

	@Test
	public void testGetIngredient() {
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
		
		assertEquals("Saffron", i3.getIngredientName());
		assertEquals("Eggs", i4.getIngredientName());
		assertNotEquals("Saffron", i4.getIngredientName());
		assertNotEquals("Eggs", i3.getIngredientName());
		
		assertEquals("Tbsp", i3.getUnit());
		assertEquals("(Eggs)", i4.getUnit());
		assertNotEquals("Tbsp", i4.getUnit());
		assertNotEquals("(Eggs)", i3.getUnit());
		
		assertEquals(1, i3.getQuantity());
		assertEquals(2, i4.getQuantity());
		assertNotEquals(2, i3.getQuantity());
		assertNotEquals(1, i4.getQuantity());
		
	}

}
