/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.framework.presentation.*;
import java.text.NumberFormat;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class BaseUI extends AbstractUI {

    protected BaseController baseController() {
        return (BaseController) getController();
    }

    @Override
    public boolean show() {
        drawFormTitle();
        boolean wantsToExit = doShow();
        showBalances();
        drawFormBorder();
        //Console.waitForKey("Press any key.");

        return wantsToExit;
    }

    protected void showBalances() {
        drawFormSeparator();
        System.out.print("| expenditure - this week: ");
        final NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
        System.out.print(currencyFormater.format(baseController().getCurrentWeekExpenditure()));
        System.out.print(" - ");
        System.out.print("this month: ");
        System.out.print(currencyFormater.format(baseController().getCurrentMonthExpenditure()));
        System.out.print(" | ");
        System.out.print("Balance: ");
        System.out.print(currencyFormater.format(baseController().getBalance()));
        System.out.println(" | ");
    }
}
