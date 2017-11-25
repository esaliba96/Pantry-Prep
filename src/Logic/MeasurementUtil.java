package Logic;

public class MeasurementUtil {
	public static String getMeasurementNames(Measurement m){
		switch(m){
		case CUP:
			return "Cup(s)";
		case TEASPOON:
			return "Teaspoon(s)";
		case TABLESPOON:
			return "Tablespoon(s)";
		case INDIVIDUAL:
			return "Individual";
		case POUND:
			return "Pound(s)";
		}
		return "error";
	}
	public static String[] getAllMeasurementNames(){
		String[] names = new String[Measurement.values().length];
		for (int i = 0; i < Measurement.values().length; i++){
			names[i] = getMeasurementNames(Measurement.values()[i]); 
		}
		return names;
	}
}
