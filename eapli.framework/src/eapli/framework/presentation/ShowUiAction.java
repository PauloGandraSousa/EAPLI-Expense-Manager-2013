/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.presentation;

import eapli.framework.Action;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ShowUiAction implements Action {

    BaseUI ui;
    
    public ShowUiAction(BaseUI ui) {
        this.ui = ui;
    }
    
    @Override
    public boolean execute() {
        ui.show();
        return false;
    }
    
}
