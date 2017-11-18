package Logic;

import java.awt.Insets;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RecipeViewScene {
	
	public static Scene getScene(Recipe r){
		
		VBox root = new VBox();

		root.getChildren().add(NavigationBar.getNavigateBox());
		root.setSpacing(15);

		Text title = new Text(r.getName());
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    root.getChildren().add(title);
	    
	    Text description = new Text(r.getDescription());
	    root.getChildren().add(description);
	    
	    HBox hbox = new HBox();
	    VBox vbox1 = new VBox();
	    VBox vbox2 = new VBox();
	    hbox.setSpacing(20);
	    root.getChildren().add(hbox);
	    hbox.getChildren().add(vbox2);
	    hbox.getChildren().add(vbox1);
	    for(Ingredient i: r.getIngredientList()){
	    	Text ingredient = new Text(i.getQuantity() + " " + i.getUnit() + i.getIngredientName());
	    	vbox1.getChildren().add(ingredient);
	    }
	    
	    int count = 0;
	    for(String s : r.getInstructionList()){
	    	count++;
	    	Text instruction = new Text(count + ". " + s);
	    	vbox2.getChildren().add(instruction);
	    }
	    
	    
		
		
		
		return new Scene(root, 400, 400);
	}
	
}

