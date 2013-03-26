/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.BaseController;
import Controllers.RegisterExpenseController;
import Model.ExpenseType;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class RegisterExpenseUI extends BaseUI {
    public void show() {
        System.out.println("* * *  REGISTER AN EXPENSE  * * *\n");
        
        String what = Console.readLine("What:");
        Date date = Console.readDate("When (dd-MM-yyyy):");
        double value = Console.readDouble("How much:");
        BigDecimal amount = new BigDecimal(value);
        
        System.out.println("-- EXPENSE TYPES --");      
        int position = 1;
        List<ExpenseType> listExpenseTypes = controller.getExpenseTypes();
        for (ExpenseType et : listExpenseTypes) {
            System.out.println(position + ". " + et.getDescription());
            position++;
        }
        int option = Console.readOption(1, position, 0);
              
        controller.registerExpense(what, date, amount, listExpenseTypes.get(option));
          
        System.out.println("\nExpense recorded!");
        
        showBalances();
    }

            RegisterExpenseController controller = new RegisterExpenseController();

    @Override
    protected BaseController controller() {
        return controller;
    }
}
