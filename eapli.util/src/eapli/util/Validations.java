/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

/**
 *
 * @author Paulo Gandra Sousa
 */
public /*static*/ class Validations {
    public static boolean isNullOrEmpty(String text) {
        return (text == null || text.trim().length() == 0);
    }
}
