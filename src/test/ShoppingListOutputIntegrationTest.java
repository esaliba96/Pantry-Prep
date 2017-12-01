//Person in Charge: Jason Lomsdalen
package test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.Test;
import logic.MyCalendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class ShoppingListOutputIntegrationTest {
	
	private static final Logger LOGGER = Logger.getLogger(RecipeDatabaseOutputIntegrationTest.class.getName());

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void test() throws IOException{
		//Construct my own Calendar Object, c
		Calendar c = Calendar.getInstance();
		Date currentDay = new Date();
		try {
			currentDay = new SimpleDateFormat("M/dd/yyyy").parse("11/15/2017");
		} catch (ParseException e) {
			LOGGER.log( Level.SEVERE, e.toString(), e );
		}
		c.setTime(currentDay);
		MyCalendar myCal = new MyCalendar(c);
		//Then call 
		final File output = new File("shoppingListDatabaseIntegrationTestFile.txt");
		
		myCal.getpi().printRecipes("shoppingListDatabaseIntegrationTestFile.txt");
		
		final File expected = folder.newFile("expectedShoppingListDatabaseIntegration.txt");
		FileWriter fw = new FileWriter(expected, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);
		out.println("Shopping list from November 15 to November 15");
		out.close();
		
		//Scanner Initialized
		Scanner expectedScanner = new Scanner(expected);
		//Scanner Initialized
		Scanner outputScanner = new Scanner(output);
		
		//Check line by line to see if the text files differ
		try {
			while (expectedScanner.hasNextLine()) {
				//Assert True
		    		assertTrue(expectedScanner.nextLine().equals(outputScanner.nextLine()));
		    }
		} finally {
			//Close Scanner
			expectedScanner.close();
			//Close Scanner
			outputScanner.close();
			
		}
		cleanUp(output.toPath());
	}
	
	public void cleanUp(Path path) throws IOException{
		  Files.delete(path);
	}
}
