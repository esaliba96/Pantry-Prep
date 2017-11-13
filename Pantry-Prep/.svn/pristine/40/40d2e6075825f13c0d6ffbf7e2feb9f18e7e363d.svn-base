package Logic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PantryPrep {
	
	public static void main(String[] args) {
		Date currentDay;
		Calendar calendar = Calendar.getInstance();
		try {
			currentDay = new SimpleDateFormat("M/dd/yyyy").parse("11/12/2017");
			calendar.setTime(currentDay);
			MyCalendar myCalendar = new MyCalendar(calendar);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
