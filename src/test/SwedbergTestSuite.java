package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MyCalendarCalendarUtilIntegrationTest.class, MyCalenderPrintIntervalIntegrationTest.class,
		TestCalendarUtil.class, TestMyCalendar.class })
public class SwedbergTestSuite {

}
