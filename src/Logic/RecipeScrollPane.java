package Logic;

import java.util.ArrayList;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class RecipeScrollPane {
	public ScrollPane sp;
	public RecipeScrollPane(ArrayList<Recipe> recipeList){
		sp = new ScrollPane();
		VBox myList = new VBox();
		for (int i = 0;i < recipeList.size();i++){
			//myList.getChildren().add();   
		}
		sp.setContent(myList);
	}
}
