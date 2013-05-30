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

    public void export(int format, String filename) {
        ExportMovementsFactory factory = ExportMovementsFactory.getInstance();
        ExportMovementsStrategy exportMovements = factory.getExporter(format);
        exportMovements.export(filename);
    }
}
