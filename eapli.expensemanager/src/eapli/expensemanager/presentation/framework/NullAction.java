/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.framework;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class NullAction implements Action {

    private static NullAction theInstance = new NullAction();
    
    private NullAction() {}
    
    public static NullAction instance() {
        return theInstance;
    }
    
    @Override
    public boolean execute() {
        return false;
    }
    
}
