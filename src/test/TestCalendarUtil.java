// Person in charge: Nathaniel Swedberg

package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import logic.CalendarUtil;

public class TestCalendarUtil {
	static final String FORMAT = "M/dd/yyyy";
	@Test
	public void testOffset() {
		Date currentDay = new Date();
		Calendar  start = Calendar.getInstance();
		try {
			currentDay = new SimpleDateFormat(FORMAT).parse("11/15/2017");
		} catch (ParseException e) {
			return;
		}
		start.setTime(currentDay);
		Calendar endDate = CalendarUtil.getOffsetDate(start, 2);
		assertEquals(17, endDate.get(Calendar.DAY_OF_MONTH), 0);
	}
	@Test
	public void testOffsetUpperbound() {
		Calendar  start = Calendar.getInstance();
		Date currentDay = new Date();
		try {
			currentDay = new SimpleDateFormat(FORMAT).parse("11/30/2017");
		} catch (ParseException e) {
			return;
		}
		start.setTime(currentDay);
		Calendar end = CalendarUtil.getOffsetDate(start, 2);
		assertEquals(2, end.get(Calendar.DAY_OF_MONTH), 0);
	}
	@Test
	public void testOffsetLowerbound() {
		Calendar  start = Calendar.getInstance();
		Date currentDay = new Date();
		try {
			currentDay = new SimpleDateFormat(FORMAT).parse("11/1/2017");
		} catch (ParseException e) {
			return;
		}
		start.setTime(currentDay);
		Calendar end = CalendarUtil.getOffsetDate(start, -2);
		assertEquals(30, end.get(Calendar.DAY_OF_MONTH), 0);
	}

}
