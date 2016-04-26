package api.core;

/**
 * @author codenozzle
 *
 */
public class ApiUtils {

	public static boolean isEqual(Object value1, Object value2, boolean ignoreNulls) {
		if (value2 == null && ignoreNulls) {
			return true;
		} else if (value1 == null && value2 == null) {
			return true;
		} else if (value1 != null && value2 != null) {
			return value1.equals(value2);
		}
		return false;
	}

}
