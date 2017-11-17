package Logic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyCalendar {
	private LinkedList<Week> weeks;
	public Calendar currentDay; 
	public Calendar selectedDay;
	private int index = 0;
	public MyCalendar(Calendar currentDay){
		Calendar c = Calendar.getInstance();
		weeks = new LinkedList<Week>();
		this.currentDay = currentDay;
		this.selectedDay = currentDay;
		System.out.println("dayOfYear: " + c.get(Calendar.DAY_OF_YEAR));
		System.out.println("year: " + c.get(Calendar.DAY_OF_YEAR));
		System.out.println("dayOfWeek" + c.get(Calendar.DAY_OF_WEEK));
		weeks.add(new Week(CalendarUtil.getOffsetDate(c,(c.get(Calendar.DAY_OF_WEEK) * -1) + 1)));
	}
	public Week getWeek(){
		System.out.println(index);
		return weeks.get(index);
	}
	public void nextWeek(){
		index++;
		if (index >= weeks.size()){
			Calendar nextSunday = CalendarUtil.getOffsetDate(weeks.get(index-1).getDay(DayOfWeek.SUNDAY),7);
			weeks.addLast(new Week(nextSunday));
		}
	}
	public void prevWeek(){
		if (index == 0){
			Calendar prevSunday = CalendarUtil.getOffsetDate(weeks.get(index).getDay(DayOfWeek.SUNDAY),-7);
			weeks.addFirst(new Week(prevSunday));
		}
		else{
			index--;
		}
	}
}