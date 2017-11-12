import java.util.Calendar;
import java.util.Date;

public class Week {
	private Day days[] = new Day[7];
	private Calendar sunday;
	public Week(Calendar sunday){
		this.sunday = sunday;
	}
	public Calendar getDay(DayOfWeek weekDay){
		switch(weekDay){
			case SUNDAY: return sunday; 
			case MONDAY: return CalendarUtil.getOffSetDate(sunday, 1);
			case TUESDAY: return CalendarUtil.getOffSetDate(sunday, 2);
			case WEDNESDAY: return CalendarUtil.getOffSetDate(sunday, 3);
			case THURSDAY: return CalendarUtil.getOffSetDate(sunday, 4);
			case FRIDAY:return CalendarUtil.getOffSetDate(sunday, 5);
			case SATURDAY:return CalendarUtil.getOffSetDate(sunday, 6);
		}
		return null;
	}
}
