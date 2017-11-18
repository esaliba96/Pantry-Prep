package Logic;

import java.util.Calendar;

import javafx.scene.control.Label;

public class DayViewLabel implements ButtonFactory{
	public Label dayView = new Label();
	private boolean isEnd; 
	public DayViewLabel(UpdateFrame uf,MyCalendar c,boolean isEnd){
		uf.addFactory(this);
		this.isEnd = isEnd;
		write(c);
	}

	@Override
	public void write(MyCalendar c) {
		System.out.println("updating Day view");
		Calendar day;
		if (isEnd){
			day = c.pi.getEnd();
		}
		else{
			day = c.pi.getBeginning();
		}
		String text = CalendarUtil.numMonthToString(day.get(Calendar.MONTH)) + "\n";
		text += day.get(Calendar.DAY_OF_MONTH);
		dayView.setText(text);
	}
}
