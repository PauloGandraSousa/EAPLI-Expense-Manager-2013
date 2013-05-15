/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterInitialBalanceController;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author arocha
 */
public class RegisterInitialBalanceUI extends BaseForm {

    @Override
    public boolean doShow() {
        Date date = Console.readDate("Reference Date (dd-MM-yyyy):");
        double initial = Console.readDouble("Initial value:");
        BigDecimal value = new BigDecimal(initial);

        controller.registerInitialBalance(date, value);

        System.out.println("\nInitial Balance recorded!");

        return true;
    }
    RegisterInitialBalanceController controller = new RegisterInitialBalanceController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public String headline() {
        return "REGISTER INITIAL BALANCE";
    }
}
