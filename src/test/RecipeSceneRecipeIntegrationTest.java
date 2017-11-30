package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import javafx.scene.layout.VBox;
import logic.Ingredient;
import logic.Recipe;
import logic.RecipeViewScene;

public class RecipeSceneRecipeIntegrationTest {

	@Test
	public void test() {
		
		VBox root = new VBox();
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "(Eggs)", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		
		Recipe recipe = new Recipe("Saffron Eggs", "A saffron eggs recipe", iList, sList);
		
		RecipeViewScene.populateDescription(root, recipe);
		RecipeViewScene.populateTitle(root, recipe);
		
		
		assertEquals("Saffron Eggs", root.getChildren().get(0));
		assertEquals("A saffron eggs recipe",root.getChildren().get(1));
		assertNotEquals("Eggs", root.getChildren().get(0));
		assertNotEquals("",root.getChildren().get(1));
	}

}
