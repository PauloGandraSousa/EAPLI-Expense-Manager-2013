/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import java.text.NumberFormat;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class BaseUI {
    
    // derived classes should provide the controller object
    protected abstract BaseController controller();
    
    protected abstract void doShow();
    public abstract String headline();
    
    public void show() {
        showHeadline();
        doShow();
        showBalances();
    }
    
    public void showBalances() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("this week expenditure: ");
        System.out.print(NumberFormat.getCurrencyInstance().format( controller().getThisWeekExpenditure()));
        System.out.print(" | ");
        System.out.print("this month expenditure: ");
        System.out.println(NumberFormat.getCurrencyInstance().format( controller().getThisMonthExpenditure()));
        System.out.println("---------------------------------------------------------------------------------");
    }

    private void showHeadline() {
        System.out.println(headline());
    }
}
