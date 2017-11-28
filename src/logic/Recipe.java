package logic;

import java.util.*;

public class Recipe {
	private List<Ingredient> ingredientList;
	private String description;
	private String name;
	private List<String> instructionList;

	public Recipe(String name, String description, List<Ingredient> ingredientList,
			List<String> instructionList) {
		this.name = name;
		this.description = description;
		this.ingredientList = ingredientList;
		this.instructionList = instructionList;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getInstructionList() {
		return instructionList;
	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInstructionList(List<String> instructionList) {
		this.instructionList = instructionList;
	}
	
	public void addIngredient(int quantity, String unit, String ingredientName) {
		Ingredient addme = new Ingredient(quantity, unit, ingredientName);
		ingredientList.add(addme);
	}
	
	public void addInstruction(String step) {
		instructionList.add(step);
	}
}