package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import logic.CalendarUtil;
import logic.DayOfWeek;
import logic.MyCalendar;

public class MyCalendarCalendarUtilIntegrationTest {
	@Test
	public void testOffsetOfCurrentDay() {
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		assertEquals(16, CalendarUtil.getOffsetDate(c.currentDay, 1).get(Calendar.DAY_OF_MONTH), 0);
	}
	@Test
	public void testOffsetOfSelectedDay() {
		Calendar start = new GregorianCalendar(2017,11,13);
		MyCalendar c = new MyCalendar(start);
		assertEquals(10, CalendarUtil.getOffsetDate(c.selectedDay, -3).get(Calendar.DAY_OF_MONTH), 0);
	}

}
