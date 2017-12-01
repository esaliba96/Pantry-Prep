// Person in charge: Nathaniel Swedberg
package test;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import logic.MyCalendar;

public class MyCalenderPrintIntervalIntegrationTest {

	@Test
	public void testInit() {
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		assertEquals(0, 15, c.getpi().getBeginning().get(Calendar.DAY_OF_MONTH));
	}
	@Test
	public void testValidation(){
		Calendar start = new GregorianCalendar(2017,11,15);
		MyCalendar c = new MyCalendar(start);
		c.getpi().endPrev();
		assertFalse(c.getpi().validate());
	}
}
