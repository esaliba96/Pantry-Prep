package Logic;

public class Ingredient{
	private int quantity;
	private String unit;
	private String ingredientName;
	
	public Ingredient(int quantity, String unit, String ingredientName)
	{
		this.quantity = quantity;
	    this.unit = unit;
	    this.ingredientName = ingredientName;
	}
	
	public int getQuantity()
	{
		return quantity; 
	}
	public String getUnit()
	{
		return unit;
	}
	public String getIngredientName()
	{
		return ingredientName;
	}
}