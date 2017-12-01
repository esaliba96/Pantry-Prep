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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.IOException;

public class ShoppingListOutputTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void test() throws IOException{
		//Construct my own Calendar Object, c
		Calendar c = new GregorianCalendar(2017,11,15);
		MyCalendar myCal = new MyCalendar(c);
		//Then call 
		final File output = new File("shoppingListDatabaseTestFile.txt");

		myCal.getpi().printRecipes("shoppingListDatabaseTestFile.txt");
		
		final File expected = folder.newFile("expectedShoppingListDatabase.txt");
		FileWriter fw = new FileWriter(expected, true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);
		out.println("Shopping list from December 15 to December 15");
		out.close();
		
		Scanner outputScanner = new Scanner(output);
		Scanner expectedScanner = new Scanner(expected);
		
		try {
			while (expectedScanner.hasNextLine()) {
				//Output String from file
		    		String outputString = outputScanner.nextLine();
		    		//Expected String from file
		    		String expectedString = expectedScanner.nextLine();
		    		assertEquals(expectedString, outputString);
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
