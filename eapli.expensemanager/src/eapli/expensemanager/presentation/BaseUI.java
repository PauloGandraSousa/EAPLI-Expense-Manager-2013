/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;

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
        System.out.println("-------------------");
        System.out.print("weekly spenditure:");
        System.out.println(controller().getThisWeekBalance());
        System.out.print("monthly spenditure:");
        System.out.println(controller().getThisMonthBalance());
        System.out.println("-------------------\n");
    }

    private void showHeadline() {
        System.out.println(headline());
    }
}
