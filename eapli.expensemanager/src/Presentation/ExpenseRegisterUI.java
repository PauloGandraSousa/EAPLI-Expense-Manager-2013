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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ExpenseRegisterUI {
    public void mainLoop() {
        ExpenseRegisterController controller = new ExpenseRegisterController();

        System.out.println("* * *  REGISTER AN EXPENSE  * * *\n");
        
        String what = Console.readLine("Description:");
        Date date = Console.readDate("When (dd-MM-yyyy):");
        double value = Console.readDouble("Amount:");
        BigDecimal amount = new BigDecimal(value);
         System.out.println("EXPENSE TYPES ");
        
        
        List<String> listExpenseTypes = controller.getExpenseTypes();
       
        int position = 0;
        for (Iterator<String> i = listExpenseTypes.iterator(); i.hasNext();)
        {
            String descr = i.next();
            position++;
            System.out.println(position + ". " + descr);
        }

        String option;
        int nOption;
        do
        {
            option = Console.readLine("Introduza opção: ");
            nOption = new Integer(option);
        } while (nOption < 1 || nOption > listExpenseTypes.size());
        
              
  //      controller.registerExpense(what, date, amount, ExpenseTypes.MISC);
          controller.registerExpense(what, date, amount, listExpenseTypes.get(nOption));
          
        System.out.println("expense recorded.");
    }
}
