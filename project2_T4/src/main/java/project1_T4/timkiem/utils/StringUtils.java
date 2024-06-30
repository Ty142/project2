package project1_T4.timkiem.utils;

public final class StringUtils {
	public static boolean checkData(String data) {
		if (data != null && !data.equals("")) {
			return true;
		}
		return false;
	}
}
