/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.PaymentMean;
import eapli.expensemanager.model.Visitor;

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
    
}
