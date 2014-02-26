/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

/**
 * An utility class for validations.
 *
 * @author Paulo Gandra Sousa
 */
public final class Validations {

	private Validations() {
	}

	/**
	 * checks whether a String is empty (zero length or all spaces) or null
	 *
	 * @param text
	 * @return
	 */
	public static boolean isNullOrEmpty(String text) {
		return (text == null || text.trim().length() == 0);
	}
}
