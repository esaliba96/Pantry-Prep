package Logic;

import java.util.Calendar;

public class PrintInterval {
	private Calendar beginning;
	private Calendar end;
	public PrintInterval(){
		beginning = Calendar.getInstance();
		end = Calendar.getInstance();
	}
	public Calendar getBeginning(){
		return beginning;
	}
	public Calendar getEnd(){
		return end;
	}
	public void setBeginning(Calendar day){
		beginning = day;
	}
	public void setEnd(Calendar day){
		end = day;
	}
}
