/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.RegisterIncomeController;
import eapli.expensemanager.controllers.BaseController;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
class RegisterIncomeUI extends BaseUI {

    @Override
    protected BaseController controller() {
        return controller;
    }
    RegisterIncomeController controller = new RegisterIncomeController();

    @Override
    public void doShow() {
        String what = Console.readLine("What:");
        Date date = Console.readDate("When (dd-MM-yyyy):");
        double value = Console.readDouble("How much:");
        BigDecimal amount = new BigDecimal(value);

        controller.registerIncome(what, date, amount);

        System.out.println("\nIncome recorded!");

    }

    @Override
    public String headline() {
        return "* * *  REGISTER AN INCOME  * * *\n";
    }
}
