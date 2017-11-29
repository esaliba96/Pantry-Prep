package test;
import logic.*;

import static org.junit.Assert.*;

import org.junit.Test;




public class TestDay {

	//Test to see if setRecipe saves the correct recipe and can return the correct recipe.
    @Test
    public void DaySetRecipeWorks() {
       
    		Day myDay = new Day();
    		
    		Recipe myRecipe1 = new Recipe("Breakfast", null, null, null);
    		Recipe myRecipe2 = new Recipe("Lunch", null, null, null);
    		Recipe myRecipe3 = new Recipe("Dinner", null, null, null);
    		
    		myDay.setRecipe(0, myRecipe1);
    		myDay.setRecipe(1, myRecipe2);
    		myDay.setRecipe(2, myRecipe3);

        // assert statements
        assertEquals(myRecipe1.getName(), myDay.getRecipe(0).getName() );
        assertEquals(myRecipe2.getName(), myDay.getRecipe(1).getName());
        assertEquals(myRecipe3.getName(), myDay.getRecipe(2).getName());
        
    }
    
    //Test to see if you can set a recipe to a spot in a day, then reset it. 
    @Test
    public void DaySetRecipeResetARecipe() {
    	Day myDay = new Day();
		
	Recipe myRecipe1 = new Recipe("Breakfast", null, null, null);
	Recipe myRecipe2 = new Recipe("Lunch", null, null, null);
	Recipe myRecipe3 = new Recipe("Dinner", null, null, null);
	
	Recipe myRecipe4 = new Recipe("New Lunch", null, null, null);
	
	myDay.setRecipe(0, myRecipe1);
	myDay.setRecipe(1, myRecipe2);
	myDay.setRecipe(2, myRecipe3);

	// assert statements
    assertEquals(myRecipe2.getName(), myDay.getRecipe(1).getName());
	
    myDay.setRecipe(1, myRecipe4);

    assertEquals(myRecipe4.getName(), myDay.getRecipe(1).getName());

    }
    
}


