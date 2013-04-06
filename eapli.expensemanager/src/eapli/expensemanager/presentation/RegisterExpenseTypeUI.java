/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterExpenseTypeController;
import eapli.util.Console;

/**
 *
 * @author arocha
 */
public class RegisterExpenseTypeUI extends BaseUI {

    @Override
    public boolean doShow() {
        String shortName = Console.readLine("Short name:");
        String descr = Console.readLine("Description:");

        controller.registerExpenseType(shortName, descr);

        System.out.println("\nExpense type recorded!");
        
        return true;
    }
    RegisterExpenseTypeController controller = new RegisterExpenseTypeController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE TYPE";
    }
}
