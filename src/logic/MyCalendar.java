package logic;
import java.util.Calendar;
import java.util.LinkedList;

public class MyCalendar {
	private LinkedList<Week> weeks;
	Calendar currentDay;
	Calendar selectedDay;
	PrintInterval pi;
	private int index = 0;
	private int currentDayIndex = 0;
	public MyCalendar(Calendar currentDay){
		Calendar c = currentDay;
		pi = new PrintInterval(currentDay);
		weeks = new LinkedList<>();
		this.currentDay = currentDay;
		this.selectedDay = currentDay;
		weeks.add(new Week(CalendarUtil.getOffsetDate(c,(c.get(Calendar.DAY_OF_WEEK) * -1) + 1)));
	}
	public Week getWeek(){
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
			currentDayIndex++;
		}
		else{
			index--;
		}
	}
	public Day getOffsetDay(int offset){
		int offsetWeekday = (currentDay.get(Calendar.DAY_OF_WEEK) - 1) + offset;
		int weekIndex = currentDayIndex + (int)Math.floor(offsetWeekday / 7.0);
		if (weekIndex >= weeks.size() || weekIndex < 0){
			return null;
		}
		Week w = weeks.get(weekIndex);
		return w.getDayRecipes(offsetWeekday % 7);
	}
	public PrintInterval getpi() {
		return this.pi;
	}
	
	public Calendar getCurrentDay() {
		return this.currentDay;
	}
	
	public Calendar getSelectedDay() {
		return this.selectedDay;
	}
}
