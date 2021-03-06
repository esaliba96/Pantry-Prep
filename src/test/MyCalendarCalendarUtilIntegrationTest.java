// Person in charge: Nathaniel Swedberg
package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import logic.CalendarUtil;
import logic.MyCalendar;

public class MyCalendarCalendarUtilIntegrationTest {
	@Test
	public void testOffsetOfCurrentDay() {
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		assertEquals(0, 16, CalendarUtil.getOffsetDate(c.getCurrentDay(), 1).get(Calendar.DAY_OF_MONTH));
	}
	@Test
	public void testOffsetOfSelectedDay() {
		Calendar start = new GregorianCalendar(2017,11,13);
		MyCalendar c = new MyCalendar(start);
		assertEquals(0, 10, CalendarUtil.getOffsetDate(c.getSelectedDay(), -3).get(Calendar.DAY_OF_MONTH));
	}

}
