/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.PaymentMethod;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListPaymentMethodsController extends BaseController {
    public List<PaymentMethod> getPaymentMethods() {
        return PaymentMethod.loadAll();
    }
}
