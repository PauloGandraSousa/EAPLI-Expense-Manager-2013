/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.PaymentMean;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListPaymentMeansController extends BaseController {
    public List<PaymentMean> getPaymentMeans() {
        return PaymentMean.loadAll();
    }
}
