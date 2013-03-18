/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import Controllers.RegisterExpenseTypeController;
import eapli.util.Console;
/**
 *
 * @author arocha
 */
public class ExpenseTypeRegisterUI {
        public void mainLoop() {
        System.out.println("* * *  REGISTER AN EXPENSE TYPE  * * *\n");
        
        String shortName = Console.readLine("Short name:");
        String descr = Console.readLine("Description:");
        
        RegisterExpenseTypeController controller = new RegisterExpenseTypeController();
        controller.registerExpenseType(shortName, descr);
        
        System.out.println("\nExpense type recorded!");
    }
}
