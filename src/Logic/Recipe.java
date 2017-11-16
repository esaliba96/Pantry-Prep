package Logic;

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
}