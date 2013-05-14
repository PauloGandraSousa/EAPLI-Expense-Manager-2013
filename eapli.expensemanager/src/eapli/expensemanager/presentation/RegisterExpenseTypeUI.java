/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterExpenseTypeController;

/**
 *
 * @author arocha
 */
public class RegisterExpenseTypeUI extends RegisterMovementTypeBaseUI {

    @Override
    public boolean doShow() {
        readGeneralData();

        controller.registerExpenseType(shortName, descr);

        System.out.println("\nExpense type recorded!");
        
        return true;
    }
    RegisterExpenseTypeController controller = new RegisterExpenseTypeController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE TYPE";
    }
}
