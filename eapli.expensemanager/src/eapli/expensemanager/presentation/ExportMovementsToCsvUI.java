
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ExportMovementsController;
import eapli.expensemanager.model.Expense;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.List;

public class ExportMovementsToCsvUI extends BaseForm {
    
        
    private ExportMovementsController controller = new ExportMovementsController();
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    public void run() {
        System.out.println("-- EXPORT MOVEMENTS TO CSV --");
        String csvMovements = controller.getMovementsInCsv();
        System.out.println(csvMovements);
    }
    
    @Override
    public boolean doShow() {
        String csvMovements = controller.getMovementsInCsv();
        System.out.println(csvMovements);
        
        return true;
    }
 
    @Override
    public String headline() {
        return "EXPORT MOVEMENTS TO CSV";    
    }
 
}
