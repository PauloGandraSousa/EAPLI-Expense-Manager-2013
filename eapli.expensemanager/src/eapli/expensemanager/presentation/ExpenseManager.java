/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.bootstrap.Bootstrap;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        
        mainLoop();        
    }

    private static void mainLoop() {
        boolean wantsToExit;
        MainMenu menu = new MainMenu();
        do {
            wantsToExit = menu.show();
        } while (!wantsToExit);
    }
}
