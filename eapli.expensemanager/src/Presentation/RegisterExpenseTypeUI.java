/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.BaseController;
import Controllers.RegisterExpenseTypeController;
import eapli.util.Console;

/**
 *
 * @author arocha
 */
public class RegisterExpenseTypeUI extends BaseUI {

    @Override
    public void doShow() {
        String shortName = Console.readLine("Short name:");
        String descr = Console.readLine("Description:");

        controller.registerExpenseType(shortName, descr);

        System.out.println("\nExpense type recorded!");
    }
    RegisterExpenseTypeController controller = new RegisterExpenseTypeController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public String headline() {
        return "* * *  REGISTER AN EXPENSE TYPE  * * *\n";
    }
}
