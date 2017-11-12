import java.util.Calendar;
import java.util.Date;

public class Week {
	private Day days[] = new Day[7];
	private Calendar sunday;
	public Week(Calendar sunday){
		this.sunday = sunday;
	}
	public Calendar getSunday(){
		return this.sunday;
	}
}
