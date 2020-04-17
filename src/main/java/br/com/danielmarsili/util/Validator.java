package br.com.danielmarsili.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The Class Validator.
 */
public class Validator {

	/**
	 * Instantiates a new pitang validator.
	 */
	private Validator() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Email is valid.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean emailIsValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	/**
	 * Phone is valid.
	 *
	 * @param phone the phone
	 * @return true, if successful
	 */
	public static boolean phoneIsValid(String phone) {
		String regex = "^(\\(?[0-9]{2}\\)?)? ?([0-9]{4,5})-?([0-9]{4})$";
		return phone.matches(regex);
	}

	/**
	 * License plate is valid.
	 *
	 * @param licensePlate the license plate
	 * @return true, if successful
	 */
	public static boolean licensePlateIsValid(String licensePlate) {
		Pattern pattern = Pattern.compile("[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}|[A-Z]{3}\\-[0-9]{4}");
		Matcher mat = pattern.matcher(licensePlate);
		return mat.matches();
	}
}
