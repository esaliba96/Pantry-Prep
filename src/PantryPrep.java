import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PantryPrep {
	
	public static void main(String[] args) {
		Date currentDay;
		try {
			currentDay = new SimpleDateFormat("M/dd/yyyy").parse("11/12/2017");
			MyCalendar myCalendar = new MyCalendar(currentDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
