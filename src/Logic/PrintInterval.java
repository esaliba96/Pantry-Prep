package Logic;

import java.util.Calendar;

public class PrintInterval {
	private Calendar beginning;
	private Calendar end;
	private int begOffset;
	private int endOffset;
	public PrintInterval(){
		beginning = Calendar.getInstance();
		end = Calendar.getInstance();
		begOffset = 0;
		endOffset = 0;
	}
	public Calendar getBeginning(){
		return beginning;
	}
	public Calendar getEnd(){
		return end;
	}
	public void beginningPrev(){
		begOffset--;
		beginning = CalendarUtil.getOffsetDate(beginning,-1);
	}
	public void beginningNext(){
		begOffset++;
		beginning = CalendarUtil.getOffsetDate(beginning,1);
	}
	public void endPrev(){
		endOffset--;
		end = CalendarUtil.getOffsetDate(end, -1);
	}
	public void endNext(){
		endOffset++;
		end = CalendarUtil.getOffsetDate(end, 1);
	}
	public boolean validate(){
		if (begOffset > endOffset){
			return false;
		}
		return true;
	}
}
