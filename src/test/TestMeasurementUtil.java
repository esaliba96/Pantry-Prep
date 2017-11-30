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
    
//    @Test
//    public void TestGetAllMeasurementNames() {
//		String[] names = new String[Measurement.values().length];
//		for (int i = 0; i < Measurement.values().length; i++){
//			names[i] = MeasurementUtil.getMeasurementNames(Measurement.values()[i]); 
//		}
//		for(int i = 0; i < names.length; i++)
//		{
//			assertEquals(MeasurementUtil.getAllMeasurementNames()[i], names);
//
//		}
//    }


}
