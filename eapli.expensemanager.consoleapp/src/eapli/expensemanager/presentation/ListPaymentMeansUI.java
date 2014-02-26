/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListPaymentMeansController;
import eapli.expensemanager.model.PaymentMean;
import eapli.expensemanager.presentation.visitors.PaymentMeanListVisitor;
import eapli.framework.presentation.ListWidget;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListPaymentMeansUI extends BaseUI {

    private final ListPaymentMeansController controller = new ListPaymentMeansController();
    private ListWidget<PaymentMean> widget;

    @Override
    protected BaseController getController() {
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
