/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.framework.Action;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExitWithMessageAction implements Action {

    @Override
    public boolean execute() {
        System.out.println("Bye, bye.");
        return true;
    }
    
}
