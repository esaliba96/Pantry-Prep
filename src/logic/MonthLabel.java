package logic;

import java.util.Calendar;

import javafx.scene.control.Label;

public class MonthLabel implements ButtonFactory{
	Label label;
	public MonthLabel(MyCalendar c,UpdateFrame uf){
		uf.addFactory(this);
		label = new Label("");
		write(c);
	}
	public void write(MyCalendar c) {
		Calendar sunday = c.getWeek().getDay(DayOfWeek.SUNDAY);
		Calendar saturday = c.getWeek().getDay(DayOfWeek.SATURDAY);
		int sundayMonth = sunday.get(Calendar.MONTH);
		int saturdayMonth = saturday.get(Calendar.MONTH);
		String myMonthString = "";
		if (saturdayMonth == sundayMonth){
			myMonthString = CalendarUtil.numMonthToString(saturdayMonth);
		}
		else{
			myMonthString += CalendarUtil.numMonthToString(sundayMonth);
			myMonthString += " / ";
			myMonthString += CalendarUtil.numMonthToString(saturdayMonth);
		}
		label.setText(myMonthString);
	}
}
