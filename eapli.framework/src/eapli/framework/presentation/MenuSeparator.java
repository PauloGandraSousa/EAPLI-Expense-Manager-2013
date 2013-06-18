/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.presentation;

import eapli.framework.actions.NullAction;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MenuSeparator extends MenuItem {
    
    public MenuSeparator() {
        super(-1, "------------------", NullAction.getInstance());
    }
    
    @Override
    public void show() {
        System.out.println(text);
    }
}
