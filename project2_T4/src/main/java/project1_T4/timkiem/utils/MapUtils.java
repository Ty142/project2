package project1_T4.timkiem.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getObject(Map<String,Object> params, String key, Class<T> Tclass) {
		Object obj = params.getOrDefault(key, null);
		if (obj != null) {
			if(Tclass.getTypeName().equals("java.lang.Long")) {
				obj = obj != "" ? Long.valueOf(obj.toString()) : null;	
			}
			else if(Tclass.getTypeName().equals("java.lang.Float")) {
				obj = obj != "" ? Float.valueOf(obj.toString()) : null;
			}
			else if(Tclass.getTypeName().equals("java.lang.String")) {
				obj = obj != "" ? String.valueOf(obj.toString()) : null;
			}
			return Tclass.cast(obj);
 		}
		return null;
	}
}
