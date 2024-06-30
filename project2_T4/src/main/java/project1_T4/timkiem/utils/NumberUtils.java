package project1_T4.timkiem.utils;

public class NumberUtils {
	public static boolean Checknum (String value) {
		if (value == null) return false;
		try {
			long number = Long.parseLong(value);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
