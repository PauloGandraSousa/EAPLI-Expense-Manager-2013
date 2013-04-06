/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterIncomeTypeController;
import eapli.util.Console;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class RegisterIncomeTypeUI extends BaseUI {

    @Override
    public boolean doShow() {
        String shortName = Console.readLine("Short name:");
        String descr = Console.readLine("Description:");

        controller.registerIncomeType(shortName, descr);

        System.out.println("\nIncome type recorded!");
        
        return true;
    }
    
    RegisterIncomeTypeController controller = new RegisterIncomeTypeController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE TYPE";
    }
}
