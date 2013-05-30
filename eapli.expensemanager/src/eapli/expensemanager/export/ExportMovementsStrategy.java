/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

/**
 * 
 * @author Fernando
 */
public interface ExportMovementsStrategy {
	String getOutput();

	public static final int CSV = 1;
	public static final int XML = 2;

	void export(String filename);
}
