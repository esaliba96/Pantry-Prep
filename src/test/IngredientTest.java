// Trevor Brown's Unit Tests

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Ingredient;

//Trevor Brown
public class IngredientTest {

	@Test
	public void testIngredientGetName() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		Ingredient i3 = new Ingredient(-1, "", "1234");
		
		assertEquals("Saffron", i1.getIngredientName());
		assertEquals("Eggs", i2.getIngredientName());
		assertEquals("1234", i3.getIngredientName());
		
		assertNotEquals("slkdj", i2.getIngredientName());
		assertNotEquals("eggs", i3.getIngredientName());
		assertNotEquals("", i1.getIngredientName());
		
	}
	
	@Test
	public void testIngredientGetQuantity() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		Ingredient i3 = new Ingredient(-1, "", "1234");
		
		assertEquals(1, i1.getQuantity());
		assertEquals(2, i2.getQuantity());
		assertEquals(-1, i3.getQuantity());
		
		assertNotEquals(0, i2.getQuantity());
		assertNotEquals(0, i3.getQuantity());
		assertNotEquals(11, i1.getQuantity());
	}
	
	@Test
	public void testIngredientGetUnit() {
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		Ingredient i3 = new Ingredient(-1, "", "1234");
		
		assertEquals("Tbsp", i1.getUnit());
		assertEquals("(Eggs)", i2.getUnit());
		assertEquals("", i3.getUnit());
		
		assertNotEquals("Saffron", i2.getUnit());
		assertNotEquals("Eggs", i3.getUnit());
		assertNotEquals("1234", i1.getUnit());
	}

}
