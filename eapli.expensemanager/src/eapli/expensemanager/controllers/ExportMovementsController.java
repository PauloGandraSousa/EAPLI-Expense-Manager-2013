/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.export.ExportMovementsFactory;
import eapli.expensemanager.export.IExportMovementsStrategy;

/**
 * 
 * @author Fernando
 */
public class ExportMovementsController extends BaseController {

    public String getExportString() {
        ExportMovementsFactory exportMovementsFactory = ExportMovementsFactory.getInstance();
        IExportMovementsStrategy exportMovements = exportMovementsFactory.getExportMovementsStrategy();
        String output = exportMovements.getOutput();
        return output;
    }
}
