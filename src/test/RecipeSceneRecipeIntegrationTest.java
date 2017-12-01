// Elie Saliba's Integration Tests

package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.Ingredient;
import logic.Recipe;
import logic.RecipeViewScene;

//Trevor Brown
public class RecipeSceneRecipeIntegrationTest {

	private static final String SAFF = "Saffron";
	private static final String EGG = "Eggs";
	private static final String EGGP = "(Eggs)";
	
	@Test
	public void test() {
		
		VBox root = new VBox();
		Ingredient i1 = new Ingredient(1, "Tbsp", SAFF);
		Ingredient i2 = new Ingredient(2, EGGP, EGG);
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		
		
		Recipe recipe = new Recipe("Saffron Eggs", " eggs recipe", iList, sList);
		
		RecipeViewScene.populateTitle(root, recipe);
		assertEquals("Saffron Eggs", ((Text) (root.getChildren().get(0))).getText());
	}
	
	@Test
	public void test2() {
	
		
		VBox root = new VBox();
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		
		Recipe recipe = new Recipe(" Eggs", "A saffron eggs recipe", iList, sList);
		
		RecipeViewScene.populateDescription(root, recipe);
		assertEquals("Description: A saffron eggs recipe", ((Text) (root.getChildren().get(0))).getText());
		

	}

}
