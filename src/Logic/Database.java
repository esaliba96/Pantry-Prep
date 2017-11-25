package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Database {
	private static HashMap<String, Recipe> recipes = new HashMap<String, Recipe>();
	private static HashMap<String, Day> planner = new HashMap<String, Day>();

	/**
	 * Loads master list of all recipes.
	 * 
	 * Recipes are stored with name, description, number of ingredients,
	 * and number of instructions. This is followed by a list of all
	 * ingredients (name, unit, and quantity) and list of all instructions.
	 * 
	 * @throws IOException
	 */
	public static void loadRecipes() throws IOException {
		File f = new File("pp_recipes.txt");
		
		if (!f.exists()) {
			return;
		}
		
		Scanner in = new Scanner(f);

		while (in.hasNextLine()) {
			String name = in.nextLine();
			String description = in.nextLine();
			int numIngredients = Integer.parseInt(in.nextLine());
			int numInstructions = Integer.parseInt(in.nextLine());
			ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
			ArrayList<String> instructionList = new ArrayList<String>();

			for (int i = 0; i < numIngredients; i++) {
				String ingredientName = in.nextLine();
				String unit = in.nextLine();
				int quantity = Integer.parseInt(in.nextLine());
				ingredientList.add(new Ingredient(quantity, unit, ingredientName));
			}

			for (int i = 0; i < numInstructions; i++) {
				instructionList.add(in.nextLine());
			}
			
			if (recipeExists(name)) {
				System.err.println("Error: Duplicate recipe name: " + name);
				System.exit(1);
			}
			
			Recipe r = new Recipe(name, description, ingredientList, instructionList);
			recipes.put(name, r);
		}

		in.close();
	}
	
	public static void saveRecipe(Recipe r) throws IOException {
		File f = new File("pp_recipes.txt");
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);

		out.println(r.getName());
		out.println(r.getDescription());
		out.println(r.getIngredientList().size());
		out.println(r.getInstructionList().size());

		for (Ingredient i : r.getIngredientList()) {
			out.println(i.getIngredientName());
			out.println(i.getUnit());
			out.println(i.getQuantity());
		}

		for (String s : r.getInstructionList()) {
			out.println(s);
		}

		out.close();
	}
	
	/**
	 * Days are stored in the following format:
	 * MMDDYYYY
	 * Breakfast
	 * Lunch
	 * Dinner
	 * 
	 * Example of pancakes for breakfast, sandwich for lunch, and no dinner
	 * on September 25th, 2017.
	 * 
	 * Note the hash symbol that prefaces each existing recipe name.
	 * 
	 * 09252017
	 * #Pancakes
	 * #Sandwich
	 * null
	 * 
	 * @throws IOException
	 */
	public static void loadPlanner() throws IOException {
		File f = new File("pp_planner.txt");
		
		if (!f.exists()) {
			return;
		}
		
		Scanner in = new Scanner(f);

		while (in.hasNextLine()) {
			String key = in.nextLine();
			Day day = new Day();
			day.setRecipe(0, getRecipeFromLine(in.nextLine()));
			day.setRecipe(1, getRecipeFromLine(in.nextLine()));
			day.setRecipe(2, getRecipeFromLine(in.nextLine()));
			planner.put(key, day);
		}

		in.close();
	}
	
	public static void savePlanner() throws IOException {
		File f = new File("pp_planner.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);

		for (String key : planner.keySet()) {
			Day day = planner.get(key);
			out.println(key);
			out.println(day.getRecipe(0));
			out.println(day.getRecipe(1));
			out.println(day.getRecipe(2));
		}

		out.close();
	}

	public static boolean recipeExists(String name) {
		return recipes.containsKey(name);
	}
	
	public static Recipe getRecipe(String name) {
		return recipes.get(name);
	}
	
	public static Day getDayMeals(Calendar cal) {
		StringBuilder sb = new StringBuilder(getMonthAsString(cal));
		sb.append(getDateAsString(cal));
		sb.append(cal.get(Calendar.YEAR));
		String key = sb.toString();
		
		if (!planner.containsKey(key)) {
			return null;
		}
		
		Day day = planner.get(key);
		return day;
	}
	
	public static void setDayMeals(Calendar cal, Day day) {
		StringBuilder sb = new StringBuilder(getMonthAsString(cal));
		sb.append(getDateAsString(cal));
		sb.append(cal.get(Calendar.YEAR));
		String key = sb.toString();
		planner.put(key, day);
	}
	
	private static String getMonthAsString(Calendar cal) {
		int month = cal.get(Calendar.MONTH) + 1;
		
		if (month < 10) {
			return "0" + month;
		}
		
		return "" + month;
	}
	
	private static String getDateAsString(Calendar cal) {
		int date = cal.get(Calendar.DATE);
		
		if (date < 10) {
			return "0" + date;
		}
		
		return "" + date;
	}
	
	private static Recipe getRecipeFromLine(String line) {
		if (line.charAt(0) != '#') {
			return null;
		}
		
		String name = line.substring(1);
		
		if (!recipeExists(name)) {
			System.err.println("Error: Recipe not found in master list: name");
			System.exit(1);
		}
		
		return getRecipe(name);
	}
}
