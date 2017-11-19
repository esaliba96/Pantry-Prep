package Logic;
public class Day {
	private Recipe[] meals;
	public Day(){
		meals = new Recipe[3];
	}
	public Recipe getRecipe(int i){
		return meals[i];
	}
}
