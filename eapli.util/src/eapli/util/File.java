/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class File {
    public static String getCurrentDirectory() {
        return new java.io.File(".").getAbsolutePath();
    }
}
