package ListLMS;

public class ValidateUtils {
	public static boolean validateStringValues(String input) {
		return (input != null && !input.trim().isEmpty());
	}

	public static boolean validatePriceValue(float input) {
		return (input > 0);
	}
	public static boolean validateIdValue(int input) {
		return (input>0);
	}
}
