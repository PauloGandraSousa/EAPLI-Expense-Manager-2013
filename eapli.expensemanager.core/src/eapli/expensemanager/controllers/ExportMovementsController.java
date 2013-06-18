/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.export.MovementsExporter;
import eapli.expensemanager.export.MovementsExporterFactory;

/**
 * 
 * @author Fernando
 */
public class ExportMovementsController extends BaseController {

	/**
	 * 
	 * @param format
	 * @param filename
	 */
	// TODO use Enum instead of int
	public void export(int format, String filename) {
		MovementsExporterFactory factory = MovementsExporterFactory
				.getInstance();
		MovementsExporter exportMovements = factory.getExporter(format);
		exportMovements.export(filename);
	}
}
