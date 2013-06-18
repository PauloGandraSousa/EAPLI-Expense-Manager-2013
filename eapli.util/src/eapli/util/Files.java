/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

/**
 * 
 * @author Paulo Gandra Sousa
 */
public final class Files {
	private Files() {

	}

	public static String getCurrentDirectory() {
		return new java.io.File(".").getAbsolutePath();
	}

	public static String ensureExtension(String filename, String extension) {
		if (!filename.endsWith(extension)) {
			return filename + extension;
		} else {
			return filename;
		}
	}
}
