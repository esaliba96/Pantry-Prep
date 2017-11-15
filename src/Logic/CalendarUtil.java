package Logic;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtil {
	//returns the date of the date c + the offset 
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
	//gets the days of the month in the given year and month
	private static int getDaysInMonth(int year,int month){
		Calendar myCal = new GregorianCalendar(year,month,1);
		return myCal.getActualMaximum(myCal.DAY_OF_MONTH);
	}
	//returns the month of the given number
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
	public static String numWeekToString(int num){
		switch (num){
			case 0: return "Sunday";
			case 1: return "Monday";
			case 2: return "Tuesday";
			case 3: return "Wednesday";
			case 4: return "Thursday";
			case 5: return "Friday";
			case 6: return "Saturday";
		}
		return "error";
	}
	//returns whether two different Calendars share the same date ignoring the time
	public static boolean compareDates(Calendar a,Calendar b){
		if (a.get(Calendar.DAY_OF_MONTH) != b.get(Calendar.DAY_OF_MONTH)){
			return false;
		}
		if (a.get(Calendar.MONTH) != b.get(Calendar.MONTH)){
			return false;
		}
		if (a.get(Calendar.YEAR) != b.get(Calendar.YEAR)){
			return false;
		}
		return true;
	}
}
 