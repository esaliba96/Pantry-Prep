package Logic;
import java.util.Calendar;
import java.util.Date;

public class Week {
	private Day days[] = new Day[7];
	private Calendar sunday;
	public Week(Calendar sunday){
		this.sunday = sunday;
	}
	public Calendar getDay(int dayOfWeek){
		return CalendarUtil.getOffsetDate(sunday, dayOfWeek);
	}
	public Calendar getDay(DayOfWeek weekDay){
		switch(weekDay){
			case SUNDAY: return sunday; 
			case MONDAY: return CalendarUtil.getOffsetDate(sunday, 1);
			case TUESDAY: return CalendarUtil.getOffsetDate(sunday, 2);
			case WEDNESDAY: return CalendarUtil.getOffsetDate(sunday, 3);
			case THURSDAY: return CalendarUtil.getOffsetDate(sunday, 4);
			case FRIDAY:return CalendarUtil.getOffsetDate(sunday, 5);
			case SATURDAY:return CalendarUtil.getOffsetDate(sunday, 6);
		}
		return null;
	}
	public Day getDayRecipes(int dayOfWeek){
		return days[dayOfWeek];
	}
}
