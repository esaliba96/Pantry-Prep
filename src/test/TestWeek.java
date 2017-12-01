package test;


import java.util.Calendar;
import static org.junit.Assert.*;
import org.junit.Test;

import logic.DayOfWeek;
import logic.Week;

public class TestWeek {

	Calendar c = Calendar.getInstance();
	Week w = new Week(c);
	Calendar result = w.getDay(DayOfWeek.TUESDAY);
	
	@Test
	public void TestYear(){	
		assertEquals(2017, result.getWeekYear(), 0);
	}
	
	@Test
	public void TestMonth(){
		assertEquals(1, result.get(5), 0);
	}
}