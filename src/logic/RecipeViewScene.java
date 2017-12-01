package logic;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RecipeViewScene {

   private RecipeViewScene() {
	   
   }

   public static Scene getScene(Recipe r) {

      VBox root = new VBox();

      root.getChildren().add(NavigationBar.getNavigateBox());
      root.setSpacing(15);

      HBox hbox = new HBox();
      VBox vbox1 = populateIngredientsList(r);
      VBox vbox2 = populateInstructionsList(r);
      try {
    	  populateTitle(root, r);
      } catch (NullPointerException e) {
    	  return null;
      }
      
      populateDescription(root, r);
      hbox.setSpacing(20);
      root.getChildren().add(hbox);
      hbox.getChildren().add(vbox2);
      hbox.getChildren().add(vbox1);
     
      return new Scene(root, 400, 400);
   }

   public static VBox populateIngredientsList( Recipe r){
	   if (r == null) {
		   return null;
	   }
	   
	   VBox vbox1 = new VBox();
	   Text ingredientsList = new Text("Ingredients");
	      
	   vbox1.getChildren().add(ingredientsList);
	   for (Ingredient i : r.getIngredientList()) {
	      Text ingredient = new Text(i.getQuantity() + " " + i.getUnit() + i.getIngredientName());
	      vbox1.getChildren().add(ingredient);
	   }
	   return vbox1;
   }
   
   public static VBox populateInstructionsList(Recipe r){
	   if (r == null) {
		   return null;
	   }
	   
	   VBox vbox2 = new VBox();
	   
	   int count = 0;
	   ArrayList<Text> textList = new ArrayList<>();
	   Text instructions = new Text("Instructions");
	   vbox2.getChildren().add(instructions);
	   for (String s : r.getInstructionList()) {
	      count++;
	      Text instruction = new Text(count + ". " + s);
	      textList.add(instruction);
	      vbox2.getChildren().add(instruction);
	   }
	   
	   return vbox2;
   }
   
   public static void populateTitle(VBox root, Recipe r){
	   Text title = new Text(r.getName());
	   title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	   root.getChildren().add(title);

   }
   
   public static void populateDescription(VBox root, Recipe r) {
	   Text description = new Text("Description: " + r.getDescription());
	      root.getChildren().add(description);
   }
}

