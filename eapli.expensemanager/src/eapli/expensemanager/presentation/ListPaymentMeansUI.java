/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.framework.ListWidget;
import eapli.expensemanager.presentation.framework.BaseUI;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListPaymentMeansController;
import eapli.expensemanager.model.PaymentMean;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListPaymentMeansUI extends BaseUI {

    ListPaymentMeansController controller = new ListPaymentMeansController();
    ListWidget<PaymentMean> widget;
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    protected boolean doShow() {
        widget = new ListWidget<PaymentMean>(controller.getPaymentMeans(), new PaymentMeanListVisitor());
        widget.show();
        
        return true;
    }

    @Override
    public String headline() {
        return "LIST PAYMENT METHODS";
    }
    
}
