//Person in Charge: Jason Lomsdalen
package test;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.util.Scanner;
import java.util.logging.Level;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import static org.junit.Assert.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;
import logic.Ingredient;
import logic.Recipe;
import logic.Database;

public class RecipeDatabaseOutputTest {
	
	private static final Logger LOGGER = Logger.getLogger(RecipeDatabaseOutputIntegrationTest.class.getName());

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();	
	
	@Test
	public void test() throws IOException {
		//Create a Recipe Object
		Ingredient i1 = new Ingredient(1, "Tbsp", "Saffron");
		Ingredient i2 = new Ingredient(2, "Individual", "Eggs");
		ArrayList<Ingredient> iList = new ArrayList<>();
		ArrayList<String> sList = new ArrayList<>();
		sList.add("Step 1");
		sList.add("Step 2");
		sList.add("Step 3");
		iList.add(i1);
		iList.add(i2);
		Recipe recipe = new Recipe("Popcorn and Butter", "A saffron eggs recipe", iList, sList);
		
		//Initialize Expected and Output txt files
		final File expected = folder.newFile("expectedRecipeDatabase.txt");
		FileWriter fw = new FileWriter(expected, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);
		out.println("Popcorn and Butter");
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
		
	    final File output = new File("recipeDatabaseTestFile.txt");
		
		Database.saveRecipeToList(recipe);
		try {
			Database.writeRecipeListToFile(recipe, "recipeDatabaseTestFile.txt");
		} catch (IOException e1) {
			LOGGER.log( Level.SEVERE, e1.toString(), e1 );
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
		cleanUp(output.toPath());
	}
	
	public void cleanUp(Path path) throws IOException{
		  Files.delete(path);
	}
}
