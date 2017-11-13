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
}
