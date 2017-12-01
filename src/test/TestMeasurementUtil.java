// Noah Paige's Tests

package test;

import logic.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMeasurementUtil {

    @Test
    public void TestGetCup() {
    		Measurement myEnum = Measurement.CUP;
    		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Cup(s)");
    		
    }
    @Test
    public void TestGetIndividual() {
		Measurement myEnum = Measurement.INDIVIDUAL;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Individual");
    }
    @Test
    public void TestGetPound() {
		Measurement myEnum = Measurement.POUND;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Pound(s)");
    }
    @Test
    public void TestGetTablespoon() {
		Measurement myEnum = Measurement.TABLESPOON;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Tablespoon(s)");
    }
    @Test
    public void TestGetTeaspoon() {
		Measurement myEnum = Measurement.TEASPOON;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Teaspoon(s)");
    }
}
