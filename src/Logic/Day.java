package Logic;

public class Day {
	private Recipe[] meals;

	public Day() {
		meals = new Recipe[3];
	}

	public void setRecipe(int i, Recipe r) {
		if (i < 0 || i > 2) {
			System.err.println("Meal index out of bounds: " + i);
			System.exit(1);
		}
		
		meals[i] = r;
	}

	public Recipe getRecipe(int i) {
		return meals[i];
	}
}
