package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class PrintInterval {
	private Calendar beginning;
	private Calendar end;
	private int begOffset;
	private int endOffset;
	private ArrayList<Ingredient> myIngredients;
	public PrintInterval(){
		beginning = Calendar.getInstance();
		end = Calendar.getInstance();
		begOffset = 0;
		endOffset = 0;
	}
	public Calendar getBeginning(){
		return beginning;
	}
	public Calendar getEnd(){
		return end;
	}
	public void beginningPrev(){
		begOffset--;
		beginning = CalendarUtil.getOffsetDate(beginning,-1);
	}
	public void beginningNext(){
		begOffset++;
		beginning = CalendarUtil.getOffsetDate(beginning,1);
	}
	public void endPrev(){
		endOffset--;
		end = CalendarUtil.getOffsetDate(end, -1);
	}
	public void endNext(){
		endOffset++;
		end = CalendarUtil.getOffsetDate(end, 1);
	}
	public ArrayList<Recipe> getRecipes(MyCalendar c){
		ArrayList<Recipe> myList = new ArrayList<Recipe>();
		for (int i = 0; i <= (endOffset - begOffset);i++){
			Day d = c.getOffsetDay(begOffset + i);
			for (int j = 0; j < 3; j++){
				if (d.getRecipe(j) != null){
					myList.add(d.getRecipe(j));
				}
			}
		}	
		return myList;
	}
	public void printRecipes(MyCalendar c){
		if (!validate()){
			System.out.println("Error: Invalid print interval");
			return;
		}
		ArrayList<Recipe> myList = getRecipes(c);
		File f = new File("shopping_list.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			for (Recipe r : myList){
				addToIngredients(r);
			}
			for (Ingredient i : myIngredients){
				out.printf("%s %d %s",i.getIngredientName(),i.getQuantity(),i.getUnit());
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void addToIngredients(Recipe r){
		for (Ingredient i : r.getIngredientList()){
			for (Ingredient j : myIngredients){
				if (i.getIngredientName().equalsIgnoreCase(j.getIngredientName())){
					if (i.getUnit().equals(j.getIngredientName())){
						j.addToQuantity(i.getQuantity());
					}
				}
			}
		}
	}
	public boolean validate(){
		if (begOffset > endOffset){
			return false;
		}
		return true;
	}
}
