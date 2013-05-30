/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Fernando
 */
public class ExportMovementsFactory {

	private static ExportMovementsFactory instance = new ExportMovementsFactory();

	private ExportMovementsFactory() {
	}

	public static ExportMovementsFactory getInstance() {
		return instance;
	}

	public ExportMovementsStrategy getExportMovementsStrategy() {
		// TODO in this case it would be acceptable for the factory to receive a
		// parameter
		// in order to decide which factory to create as this will be a user
		// decision
		// and not a configuration setting
		String strClassName = System.getProperty("ExportMovementsStrategy");
		System.out.println("strClassName: " + strClassName);
		try {
			return (ExportMovementsStrategy) Class.forName(strClassName)
					.newInstance();
		} catch (Exception exc) {
			Logger.getLogger("ExpenseManager").log(Level.SEVERE, null, exc);
			return null;
		}
	}

	public ExportMovementsStrategy getExporter(int format) {
		switch (format) {
		case ExportMovementsStrategy.CSV:
			return new ExportMovementsCsv();

		case ExportMovementsStrategy.XML:
			return new ExportMovementsXml();

		default:
			return null;
		}
	}
}
