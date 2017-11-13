package Logic;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtil {
	public static Calendar getOffsetDate(Calendar c, int offSet){
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		dayOfMonth += offSet;
		if (dayOfMonth < 1){
			month--;
			if (month < 1){
				year--;
				month = 12;
			}
			dayOfMonth += getDaysInMonth(year,month);
		}
		else if (dayOfMonth > c.getActualMaximum(c.DAY_OF_MONTH)){
			month++;
			if (month > 12){
				year++;
				month = 1;
			}
			dayOfMonth -= getDaysInMonth(year,month-1);
		}
		Calendar myCal = new GregorianCalendar(year,month,dayOfMonth);
		return myCal;
	}
	private static int getDaysInMonth(int year,int month){
		Calendar myCal = new GregorianCalendar(year,month,1);
		return myCal.getActualMaximum(myCal.DAY_OF_MONTH);
	}
	public static String numMonthToString(int num){
		switch(num){
			case 0: return "January";
			case 1: return "Febuary";
			case 2: return "March";
			case 3: return "April";
			case 4: return "May";
			case 5: return "June";
			case 6: return "July";
			case 7: return "August";
			case 8: return "September";
			case 9: return "October";
			case 10: return "November";
			case 11: return "December";
		}
		return "error";
	}
}
