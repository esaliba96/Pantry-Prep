package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import logic.CalendarUtil;

public class TestOffsetUpperEdge {

	@Test
	public void test() {
		Calendar  start = Calendar.getInstance();
		Date currentDay = new Date();
		try {
			currentDay = new SimpleDateFormat("M/dd/yyyy").parse("11/30/2017");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start.setTime(currentDay);
		Calendar end = CalendarUtil.getOffsetDate(start, 2);
		assertEquals(2, end.get(end.DAY_OF_MONTH), 0);
	}

}