package Logic;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RecipeViewScene {
	
	public static Scene getScene(MyCalendar c, Recipe r){
		
		VBox root = new VBox();
		root.getChildren().add(NavigationBar.getNavigateBox());

		Text title = new Text(r.getName());
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    root.getChildren().add(title);
	    
	    Text description = new Text(r.getDescription());
	    root.getChildren().add(description);
	    
	    for(Ingredient i: r.getIngredientList()){
	    	Text ingredient = new Text(i.getQuantity() + " " + i.getUnit() + i.getIngredientName());
	    	root.getChildren().add(description);
	    }
	    
	    int count = 0;
	    for(String s : r.getInstructionList()){
	    	count++;
	    	Text instruction = new Text(count + ". " + s);
	    }
	    
	    
		
		
		
		return new Scene(root, 400, 400);
	}
	
}

