//Person in Charge: Jason Lomsdalen
package test;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import static org.junit.Assert.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import logic.Ingredient;
import logic.Recipe;
import logic.Database;

public class RecipeDatabaseOutputIntegrationTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();	
	
	@Test
	public void test() throws IOException {
		//Create a Recipe Object
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "Individual", "Eggs");
		//Integration Test: Test Output as well as Ingredient Class
		Ingredient testIngredClass  =new Ingredient(i1.getQuantity(), i1.getUnit(), i1.getIngredientName());
		ArrayList<Ingredient> iList = new ArrayList<Ingredient>();
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(testIngredClass);
		iList.add(i2);
		Recipe recipe = new Recipe("Eggs on Toast with Bacon", "A saffron eggs recipe", iList, sList);
		//Integration Test: Test Output and Recipe Class
		Recipe testRecipeClass = new Recipe(recipe.getName(), recipe.getDescription(), recipe.getIngredientList(), recipe.getInstructionList());
		
		//Initialize Expected and Output txt files
		final File expected = folder.newFile("expectedRecipeDatabase.txt");
		FileWriter fw = new FileWriter(expected, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);
		out.println("Eggs on Toast with Bacon");
		out.println("A saffron eggs recipe");
		out.println("2");
		out.println("3");
		out.println("Saffron");
		out.println("Tbsp");
		out.println("1");
		out.println("Eggs");
		out.println("Individual");
		out.println("2");
		out.println("Step 1");
		out.println("Step 2");
		out.println("Step 3");
		out.close();
		
	    final File output = new File("recipeDatabaseIntegrationTestFile.txt");
	    output.delete();
		
		Database.saveRecipeToList(testRecipeClass);
		try {
			Database.writeRecipeListToFile(testRecipeClass, "recipeDatabaseIntegrationTestFile.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Scanner outputScanner = new Scanner(output);
		Scanner expectedScanner = new Scanner(expected);
		
		try {
			while (expectedScanner.hasNextLine()) {
		    		assertTrue(expectedScanner.nextLine().equals(outputScanner.nextLine()));
		    }
		} finally {
			outputScanner.close();
			expectedScanner.close();
		}
	}
}
