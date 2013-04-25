/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.PaymentMethod;
import eapli.expensemanager.model.Visitor;

/**
 *
 * @author Paulo Gandra Sousa
 */
class PaymentMethodListVisitor implements Visitor<PaymentMethod> {

    public PaymentMethodListVisitor() {
    }

    @Override
    public void visit(PaymentMethod visited) {
        System.out.println(visited.getDescription());
    }
    
}
