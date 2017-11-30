package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import logic.DayOfWeek;
import logic.MyCalendar;
public class TestMyCalendar {

	@Test
	public void testWeek() {
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		assertEquals(11, c.getWeek().getDay(DayOfWeek.MONDAY).get(Calendar.DAY_OF_MONTH), 0);
	}
	@Test
	public void testNextWeek(){
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		c.nextWeek();
		assertEquals(17,c.getWeek().getDay(DayOfWeek.SUNDAY).get(Calendar.DAY_OF_MONTH), 0);
	}
	@Test
	public void testPrevWeek(){
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		c.prevWeek();
		assertEquals(3,c.getWeek().getDay(DayOfWeek.SUNDAY).get(Calendar.DAY_OF_MONTH), 0);
	}

}
