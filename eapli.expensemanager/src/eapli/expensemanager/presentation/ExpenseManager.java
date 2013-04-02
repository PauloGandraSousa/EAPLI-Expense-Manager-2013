/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

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
        
        MainMenu menu = new MainMenu();
        menu.mainLoop();
    }
}
