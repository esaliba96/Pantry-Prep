package Logic;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class AddIngredientScene {
	public static Scene getScene(Recipe recipe){
		
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        rootNode.add(new Label("Ingredient:"), 0, 0);
        TextField nameField = new TextField();
        rootNode.add(nameField, 1, 0);
        rootNode.add(new Label("Amount:"), 0, 1);
        TextField amountField = new TextField();
        rootNode.add(amountField, 1, 1);
        Button aButton = new Button("add to recipe");
        rootNode.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);

        aButton.setOnAction(e -> {
        		String name = nameField.getText();
        		String amount = nameField.getText();
            recipe.addIngredient(name, amount);
        });

		
		 
	       
		
		return new Scene(rootNode,400,400);
	}
	
}