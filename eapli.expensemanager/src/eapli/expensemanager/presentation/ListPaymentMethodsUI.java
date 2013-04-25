/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.framework.ListWidget;
import eapli.expensemanager.presentation.framework.BaseUI;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListPaymentMethodsController;
import eapli.expensemanager.model.PaymentMethod;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListPaymentMethodsUI extends BaseUI {

    ListPaymentMethodsController controller = new ListPaymentMethodsController();
    ListWidget<PaymentMethod> widget;
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    protected boolean doShow() {
        widget = new ListWidget<PaymentMethod>(controller.getPaymentMethods(), new PaymentMethodListVisitor());
        widget.show();
        
        return true;
    }

    @Override
    public String headline() {
        return "LIST PAYMENT METHODS";
    }
    
}
