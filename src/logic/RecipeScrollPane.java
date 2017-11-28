package logic;

import java.util.List;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class RecipeScrollPane {
	ScrollPane sp;
	public RecipeScrollPane(List<Recipe> recipeList, MealSlotButton mb){
		sp = new ScrollPane();
		VBox myList = new VBox();
		for (int i = 0;i < recipeList.size();i++){
			myList.getChildren().add(new RecipeButton(recipeList.get(i), mb).text);
		}
		sp.setContent(myList);
	}
}
