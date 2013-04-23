/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.bootstrap.Bootstrap;
import eapli.expensemanager.bootstrap.SomeDataBootstrap;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // call the bootstraper
        // the next line should be removed for "production" ready deployment
        Bootstrap bootstrap = new Bootstrap(); 
        //Bootstrap bootstrap = new SomeDataBootstrap();
        
        MainMenu menu = new MainMenu();
        menu.mainLoop();        
    }
}
