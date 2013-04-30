/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.framework;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MenuSeparator extends MenuItem {
    
    public MenuSeparator() {
        super(-1, null, NullAction.instance());
    }
    
    @Override
    public void show() {
        System.out.println("------------------");
    }
}
