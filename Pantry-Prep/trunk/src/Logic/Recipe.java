package Logic;


public class Recipe{
   private ArrayList<Ingredients> ingredientList;
   private String description;
   private String name;
   private ArrayList<String> instructionList;

   public Recipe(String name, String description, 
      ArrayList<Ingredients> ingredientList, ArrayList<String> instructionList){

         this.name = name;
         this.description = description;
         this.ingredientList = ingredientList;
         this.instructionList = instructionList;
   }

   public getName(){
      return name;
   }

   public getDescription(){
      return description;
   }

   public getInstructionList(){
      return instructionList;
   }

   public getIngredientList(){
      return ingredientList;
   }
}