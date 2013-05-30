/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.PaymentMean;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Paulo Gandra Sousa
 */
class PaymentMeanListVisitor implements Visitor<PaymentMean> {

    public PaymentMeanListVisitor() {
    }

    @Override
    public void visit(PaymentMean visited) {
        System.out.println(visited.getDescription());
    }

    @Override
    public void beforeVisiting(PaymentMean visited) {
        //nothing to do
    }

    @Override
    public void afterVisiting(PaymentMean visited) {
        //nothing to do
    }
}
