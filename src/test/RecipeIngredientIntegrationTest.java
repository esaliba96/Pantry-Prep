// Trevor Brown's Integration Tests

package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.Ingredient;
import logic.Recipe;

public class RecipeIngredientIntegrationTest {

	private static final String SAFF = "Saffron";
	private static final String EGG = "Eggs";
	private static final String EGGP = "(Eggs)";
	
	@Test
	public void testGetIngredient() {
		Ingredient i1 = new Ingredient(1, "Tbsp", SAFF);
		Ingredient i2 = new Ingredient(2, EGGP, EGG);
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
		
		assertEquals(SAFF, i3.getIngredientName());
		assertEquals(EGG, i4.getIngredientName());
		assertNotEquals(SAFF, i4.getIngredientName());
		assertNotEquals(EGG, i3.getIngredientName());
		
		assertEquals("Tbsp", i3.getUnit());
		assertEquals(EGGP, i4.getUnit());
		assertNotEquals("Tbsp", i4.getUnit());
		assertNotEquals(EGGP, i3.getUnit());
		
		assertEquals(1, i3.getQuantity());
		assertEquals(2, i4.getQuantity());
		assertNotEquals(2, i3.getQuantity());
		assertNotEquals(1, i4.getQuantity());
		
	}
	
	@Test
	public void testSetIngredientList() {
		Ingredient oldIng = new Ingredient(1, "Tbsp", SAFF);
		ArrayList<Ingredient> oldList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		oldList.add(oldIng);
			
		Recipe r1 = new Recipe("Saffron Eggs", "A saffron eggs recipe", 
				oldList, sList);
				
		Ingredient newIng = new Ingredient(2, "Tbsp", SAFF);
		ArrayList<Ingredient> newList = new ArrayList<Ingredient>();
		newList.add(newIng);
		r1.setIngredientList(newList);
		
		ArrayList<Ingredient> outputList = (ArrayList<Ingredient>) r1.getIngredientList();
		Ingredient outputIng = outputList.get(0);
		
		assertEquals(newIng.getQuantity(), outputIng.getQuantity());
	}

}
