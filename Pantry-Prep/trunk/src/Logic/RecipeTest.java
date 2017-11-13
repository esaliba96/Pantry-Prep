package Logic;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class RecipeTest {

	@Test
	public void testName() {
		Ingredient i1 = new Ingredient("Saffron", "1Tbsp");
		Ingredient i2 = new Ingredient("Eggs", "2");
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
		Ingredient i1 = new Ingredient("Saffron", "1Tbsp");
		Ingredient i2 = new Ingredient("Eggs", "2");
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
	

}
