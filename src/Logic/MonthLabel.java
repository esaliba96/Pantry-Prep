package Logic;

import java.util.Calendar;

import javafx.scene.control.Label;

public class MonthLabel implements ButtonFactory{
	public Label monthLabel;
	public MonthLabel(MyCalendar c,UpdateFrame uf){
		uf.addFactory(this);
		monthLabel = new Label("");
		write(c);
	}
	public void write(MyCalendar c) {
		Calendar Sunday = c.getWeek().getDay(DayOfWeek.SUNDAY);
		Calendar Saturday = c.getWeek().getDay(DayOfWeek.SATURDAY);
		int SundayMonth = Sunday.get(Calendar.MONTH);
		int SaturdayMonth = Saturday.get(Calendar.MONTH);
		if (SaturdayMonth == SundayMonth){
			monthLabel.setText(CalendarUtil.numMonthToString(SaturdayMonth));
		}
		else{
			String myMonthString = "";
			myMonthString += CalendarUtil.numMonthToString(SundayMonth);
			myMonthString += " / ";
			myMonthString += CalendarUtil.numMonthToString(SaturdayMonth);
			monthLabel.setText(myMonthString);
		}
	}
}
