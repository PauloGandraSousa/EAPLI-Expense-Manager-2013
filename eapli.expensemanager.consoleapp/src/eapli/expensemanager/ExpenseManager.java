/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager;

import eapli.expensemanager.bootstrap.ReferenceDataBootstrap;
import eapli.expensemanager.bootstrap.SomeDefaultAlertLimitBootstrap;
import eapli.expensemanager.bootstrap.SomeExpensesBootstrap;
import eapli.expensemanager.bootstrap.SomeIncomesBootstrap;
import eapli.expensemanager.presentation.MainMenu;

/**
 *
 * @author Paulo Gandra Sousa
 */
public final class ExpenseManager {

    private ExpenseManager() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // call the bootstraper
        // the next line should be removed for "production" ready deployment
        doBootstrap();

        final MainMenu menu = new MainMenu();
        menu.mainLoop();
    }

    private static void doBootstrap() {
        new ReferenceDataBootstrap().bootstrap();

        new SomeIncomesBootstrap().bootstrap();

        new SomeExpensesBootstrap().bootstrap();

        new SomeDefaultAlertLimitBootstrap().bootstrap();
    }
}
