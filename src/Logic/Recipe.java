package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Recipe {
	private ArrayList<Ingredient> ingredientList;
	private String description;
	private String name;
	private ArrayList<String> instructionList;

	public Recipe(String name, String description, ArrayList<Ingredient> ingredientList,
			ArrayList<String> instructionList) {
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

	public ArrayList<String> getInstructionList() {
		return instructionList;
	}

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInstructionList(ArrayList<String> instructionList) {
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