package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Recipe
{
   private ArrayList<Ingredient> ingredientList;
   private String description;
   private String name;
   private ArrayList<String> instructionList;

   public Recipe(String name, String description, ArrayList<Ingredient> ingredientList, ArrayList<String> instructionList)
   {
         this.name = name;
         this.description = description;
         this.ingredientList = ingredientList;
         this.instructionList = instructionList;
   }

   public String getName(){
      return name;
   }

   public String getDescription(){
      return description;
   }

   public ArrayList<String> getInstructionList(){
      return instructionList;
   }

   public ArrayList<Ingredient> getIngredientList(){
      return ingredientList;
   }
   
   public void addIngredient(int quantity, String unit, String ingredientName){
	   Ingredient addme = new Ingredient(quantity, unit, ingredientName);
	   ingredientList.add(addme);
   }
   
   public void writeToFile() throws IOException {
	   File out = new File("recipes.txt");
	   FileWriter fw = new FileWriter(out, true);
	   BufferedWriter bw = new BufferedWriter(fw);
	   
	   bw.append(name);
	   bw.append(description);
	   bw.append(ingredientList.size() + "");
	   bw.append(instructionList.size() + "");
	   
	   for (Ingredient i : ingredientList) {
		   bw.append(i.getIngredientName());
		   bw.append(i.getUnit());
		   bw.append(i.getQuantity() + "");
	   }
	   
	   for (String s : instructionList) {
		   bw.append(s);
	   }
   }
   
   public static Recipe readFromFile(Scanner in) throws IOException {
	   
	   if (!in.hasNextLine()) {
		   return null;
	   }
	   
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
	   
	   return new Recipe(name, description, ingredientList, instructionList);
   }
}