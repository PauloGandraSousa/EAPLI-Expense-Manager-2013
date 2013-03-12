/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import Controllers.ExpenseTypeRegisterController;
import eapli.util.Console;
/**
 *
 * @author arocha
 */
public class ExpenseTypeRegisterUI {
        public void mainLoop() {
        System.out.println("* * *  REGISTER AN EXPENSE TYPE  * * *\n");
        
        String descr = Console.readLine("Description:");
        
        ExpenseTypeRegisterController controller = new ExpenseTypeRegisterController();
        controller.registerTypeExpense(descr);
        
        System.out.println("expense type recorded.");
    }
}
