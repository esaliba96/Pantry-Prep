import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyCalendar {
	private LinkedList<Week> weeks;
	private Calendar currentDay; 
	private int index = 0;
	public MyCalendar(Calendar currentDay){
		Calendar c = Calendar.getInstance();
		this.currentDay = currentDay;
		System.out.println("dayOfYear: " + c.get(Calendar.DAY_OF_YEAR));
		System.out.println("year: " + c.get(Calendar.DAY_OF_YEAR));
		System.out.println("dayOfWeek" + c.get(Calendar.DAY_OF_WEEK));
		weeks.add(new Week(getOffSetDate(c,(Calendar.DAY_OF_WEEK * -1) + 1)));
	}
	private Calendar getOffSetDate(Calendar c, int offSet){
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
			dayOfMonth -= getDaysInMonth(year,month);
		}
		Calendar myCal = new GregorianCalendar(year,month,dayOfMonth);
		return myCal;
	}
	private int getDaysInMonth(int year,int month){
		Calendar myCal = new GregorianCalendar(year,month,1);
		return myCal.getActualMaximum(myCal.DAY_OF_MONTH);
	}
	public Week getWeek(){
		return weeks.get(index);
	}
	public void nextWeek(){
		index++;
		if (index >= weeks.size()){
			Calendar nextSunday = getOffSetDate(weeks.get(index-1).getSunday(),7);
			weeks.addLast(new Week(nextSunday));
		}
	}
	public void prevWeek(){
		index--;
		if (index < 0){
			Calendar prevSunday = getOffSetDate(weeks.get(index + 1).getSunday(),-7);
		}
	}
}
