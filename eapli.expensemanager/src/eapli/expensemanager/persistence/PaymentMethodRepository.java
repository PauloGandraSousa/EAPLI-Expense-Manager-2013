/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMethod;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface PaymentMethodRepository {
    //Cash getCash();
    
    List<PaymentMethod> all();
    
    PaymentMethod save(PaymentMethod paymentMethod);

    public Cash getCash(String EUR);
}
