package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PrintInterval {

   private Calendar beginning;
   private Calendar end;
   private int begOffset;
   private int endOffset;
   private ArrayList<Ingredient> myIngredients;

   public PrintInterval() {
      myIngredients = new ArrayList<>();
      beginning = Calendar.getInstance();
      end = Calendar.getInstance();
      begOffset = 0;
      endOffset = 0;
   }

   public Calendar getBeginning() {
      return beginning;
   }

   public Calendar getEnd() {
      return end;
   }

   public void beginningPrev() {
      begOffset--;
      beginning = CalendarUtil.getOffsetDate(beginning, -1);
   }

   public void beginningNext() {
      begOffset++;
      beginning = CalendarUtil.getOffsetDate(beginning, 1);
   }

   public void endPrev() {
      endOffset--;
      end = CalendarUtil.getOffsetDate(end, -1);
   }

   public void endNext() {
      endOffset++;
      end = CalendarUtil.getOffsetDate(end, 1);
   }

   public List<Recipe> getRecipes() {
      List<Recipe> myList = new ArrayList<>();
      for (int i = 0; i <= (endOffset - begOffset); i++) {
         Day d = Database.getMealsFromPlanner(CalendarUtil.getOffsetDate(beginning, i));
         if (d != null) {
            for (int j = 0; j < 3; j++) {
               if (d.getRecipe(j) != null) {
                  myList.add(d.getRecipe(j));
               }
            }
         }
      }
      return myList;
   }

   public void printRecipes() {
      if (!validate()) {
         return;
      }
      List<Recipe> myList = getRecipes();
      File f = new File("shopping_list.txt");
      FileWriter fw;
      try {
         fw = new FileWriter(f, false);
         PrintWriter out;
         String listTitle;
         try (BufferedWriter bw = new BufferedWriter(fw)) {
            out = new PrintWriter(bw);
         }
         listTitle = "Shopping list from ";
         listTitle += CalendarUtil.numMonthToString(beginning.get(Calendar.MONTH));
         listTitle += (" " + beginning.get(Calendar.DAY_OF_MONTH) + " to ");
         listTitle += CalendarUtil.numMonthToString(end.get(Calendar.MONTH));
         listTitle += (" " + end.get(Calendar.DAY_OF_MONTH));
         out.println(listTitle);
         for (Recipe r : myList) {
            addToIngredients(r);
         }
         for (Ingredient i : myIngredients) {
            out.printf("%s %d %s%n", i.getIngredientName(), i.getQuantity(), i.getUnit());
         }
         out.close();
      } catch (IOException e) {
         return;
      }

   }

   private void addToIngredients(Recipe r) {
      for (Ingredient i : r.getIngredientList()) {
         boolean found = false;
         for (Ingredient j : myIngredients) {
            if (i.getIngredientName().equalsIgnoreCase(j.getIngredientName()) && i.getUnit()
                .equals(j.getUnit())) {
               j.addToQuantity(i.getQuantity());
               found = true;
            }
         }
         if (!found && i != null) {
            myIngredients.add(i);
         }
      }
   }

   public boolean validate() {
      return begOffset <= endOffset;
   }
}
