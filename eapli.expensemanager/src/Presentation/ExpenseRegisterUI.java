/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.ExpenseRegisterController;
import Model.ExpenseRecord;
import Model.ExpenseTypes;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ExpenseRegisterUI {
    public void mainLoop() {
        System.out.println("* * *  REGISTER AN EXPENSE  * * *\n");
        
        String what = Console.readLine("Description:");
        Date date = Console.readDate("When (dd-MM-yyyy):");
        double value = Console.readDouble("Amount:");
        BigDecimal amount = new BigDecimal(value);
        
        ExpenseRegisterController controller = new ExpenseRegisterController();
        controller.registerExpense(what, date, amount, ExpenseTypes.MISC);
        
        System.out.println("expense recorded.\n\n");
    }    
}
