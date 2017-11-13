package Logic;

import static org.junit.Assert.*;

import org.junit.Test;



public class IngredientTest {

	@Test
	public void testGetAmount() {
		Ingredient i1 = new Ingredient("Saffron", "1Tbsp");
		Ingredient i2 = new Ingredient("Eggs", "");
		
		assertEquals("1Tbsp", i1.getAmount());
		assertEquals("", i2.getAmount());
		assertNotEquals("1Tbsp", i2.getAmount());
		assertNotEquals("", i1.getAmount());

	}
	
	@Test
	public void testGetName() {
		Ingredient i1 = new Ingredient("Saffron", "1Tbsp");
		Ingredient i2 = new Ingredient("Eggs", "");
		
		assertEquals("Saffron", i1.getName());
		assertEquals("Eggs", i2.getName());
		assertNotEquals("", i1.getAmount());
		assertNotEquals("Saffron", i2.getAmount());
	}

}
