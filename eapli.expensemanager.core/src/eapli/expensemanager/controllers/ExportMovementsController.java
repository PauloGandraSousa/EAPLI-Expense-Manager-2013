/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.export.MovementsExporterFactory;
import eapli.expensemanager.export.MovementsExporter;

/**
 *
 * @author Fernando
 */
public class ExportMovementsController extends BaseController {

    public void export(int format, String filename) {
        MovementsExporterFactory factory = MovementsExporterFactory.getInstance();
        MovementsExporter exportMovements = factory.getExporter(format);
        exportMovements.export(filename);
    }
}
