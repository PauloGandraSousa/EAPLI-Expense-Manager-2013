/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.framework.presentation.ListWidget;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterSavingWithdrawController;

/**
 *
 * @author ajs
 */
class RegisterSavingWithdrawUI extends BaseForm {

    ListWidget widget;

    @Override
    public String headline() {
        return "REGISTER AN SAVING WITHDRAW";
    }

    @Override
    public boolean doShow() {


        return true;
    }
    
    RegisterSavingWithdrawController controller = new RegisterSavingWithdrawController();

    @Override
    protected BaseController controller() {
        return controller;
    }

}

