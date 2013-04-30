/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.framework;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface Action {
    /**
     * 
     * @return true if this "scope" should end
     */
    boolean execute();
}
