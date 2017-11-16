package Logic;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RecipeScrollPane {
	public ScrollPane sp;
	public RecipeScrollPane(ArrayList<Recipe> recipeList, MealSlotButton mb){
		sp = new ScrollPane();
		VBox myList = new VBox();
		for (int i = 0;i < recipeList.size();i++){
			myList.getChildren().add(new RecipeButton(recipeList.get(i), mb).recipeButton);   
		}
		sp.setContent(myList);
	}
}
