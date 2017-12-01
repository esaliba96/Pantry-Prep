// Trevor Brown's Unit Tests

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Ingredient;

//Trevor Brown
public class IngredientTest {

	private static final String SAFF = "Saffron";
	private static final String EGG = "Eggs";
	private static final String EGGP = "(Eggs)";
	
	@Test
	public void testIngredientGetName() {
		Ingredient i1 = new Ingredient(1, "Tbsp", SAFF);
		Ingredient i2 = new Ingredient(2, EGGP, EGG);
		Ingredient i3 = new Ingredient(-1, "", "1234");
		
		assertEquals(SAFF, i1.getIngredientName());
		assertEquals(EGG, i2.getIngredientName());
		assertEquals("1234", i3.getIngredientName());
		
		assertNotEquals("slkdj", i2.getIngredientName());
		assertNotEquals(EGG, i3.getIngredientName());
		assertNotEquals("", i1.getIngredientName());
		
	}
	
	@Test
	public void testIngredientGetQuantity() {
		Ingredient i1 = new Ingredient(1, "Tbsp", SAFF);
		Ingredient i2 = new Ingredient(2, EGGP, EGG);
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
		Ingredient i1 = new Ingredient(1, "Tbsp", SAFF);
		Ingredient i2 = new Ingredient(2, EGGP, EGG);
		Ingredient i3 = new Ingredient(-1, "", "23");
		
		assertEquals("Tbsp", i1.getUnit());
		assertEquals(EGGP, i2.getUnit());
		assertEquals("", i3.getUnit());
		
		assertNotEquals(SAFF, i2.getUnit());
		assertNotEquals(EGG, i3.getUnit());
		assertNotEquals("23", i1.getUnit());
	}

}
