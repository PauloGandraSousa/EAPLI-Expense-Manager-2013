/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.FileInputStream;
import java.util.Properties;
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
    
    public IExportMovementsStrategy getExportMovementsStrategy() {
        String strClassName = System.getProperty("ExportMovementsStrategy");
        System.out.println("strClassName: " + strClassName);
        try {
            return (IExportMovementsStrategy) Class.forName(strClassName).newInstance();
        }
        catch (Exception exc) {
            Logger.getLogger("ExpenseManager").log(Level.SEVERE, null, exc);
            return null;
        }
    }
    
}
