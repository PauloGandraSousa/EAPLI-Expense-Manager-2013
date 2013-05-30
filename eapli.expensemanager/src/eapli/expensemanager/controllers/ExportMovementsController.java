/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.export.ExportMovementsFactory;
import eapli.expensemanager.export.ExportMovementsStrategy;

/**
 * 
 * @author Fernando
 */
public class ExportMovementsController extends BaseController {

	public String getExportString() {
		ExportMovementsFactory exportMovementsFactory = ExportMovementsFactory
				.getInstance();
		ExportMovementsStrategy exportMovements = exportMovementsFactory
				.getExportMovementsStrategy();
		String output = exportMovements.getOutput();
		return output;
	}

	public void export(int format, String filename) {
		ExportMovementsFactory factory = ExportMovementsFactory.getInstance();
		ExportMovementsStrategy exportMovements = factory.getExporter(format);
		exportMovements.export(filename);
	}
}
