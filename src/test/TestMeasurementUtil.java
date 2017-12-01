// Noah Paige's Tests

package test;

import logic.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMeasurementUtil {

    @Test
    public void testGetCup() {
    		Measurement myEnum = Measurement.CUP;
    		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Cup(s)");
    		
    }
    @Test
    public void testGetIndividual() {
		Measurement myEnum = Measurement.INDIVIDUAL;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Individual");
    }
    @Test
    public void testGetPound() {
		Measurement myEnum = Measurement.POUND;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Pound(s)");
    }
    @Test
    public void testGetTablespoon() {
		Measurement myEnum = Measurement.TABLESPOON;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Tablespoon(s)");
    }
    @Test
    public void testGetTeaspoon() {
		Measurement myEnum = Measurement.TEASPOON;
		assertEquals(MeasurementUtil.getMeasurementNames(myEnum), "Teaspoon(s)");
    }
}
