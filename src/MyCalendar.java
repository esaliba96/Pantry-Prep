import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import sun.util.calendar.BaseCalendar.Date;

public class MyCalendar {
	private LinkedList<Week> weeks;
	private int dayOfYear;
	private int year;
	private int index;
	public MyCalendar(String dateString){
		Calendar c = Calendar.getInstance();
		java.util.Date date;
		try {
			date = new SimpleDateFormat("M/dd/yyyy").parse(dateString);
			c.setTime(date);
			dayOfYear = c.get(Calendar.DAY_OF_YEAR);
			year = c.get(Calendar.YEAR);
			System.out.println("dayOfYear: " + dayOfYear);
			System.out.println("year: " + year);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block\
			System.out.println("wrong date format");
		}
	}
	public Week getWeek(){
		return weeks.get(index);
	}
	public void getNextWeek(){
		
	}
	public void getPrevWeek(){
		
	}
}
