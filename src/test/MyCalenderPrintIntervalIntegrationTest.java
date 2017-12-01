// Person in charge: Nathaniel Swedberg
package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import logic.CalendarUtil;
import logic.MyCalendar;

public class MyCalenderPrintIntervalIntegrationTest {

	@Test
	public void testInit() {
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		assertEquals(15, c.pi.getBeginning().get(Calendar.DAY_OF_MONTH), 0);
	}
	@Test
	public void testValidation(){
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		c.pi.endPrev();
		assertFalse(c.pi.validate());
	}

}
