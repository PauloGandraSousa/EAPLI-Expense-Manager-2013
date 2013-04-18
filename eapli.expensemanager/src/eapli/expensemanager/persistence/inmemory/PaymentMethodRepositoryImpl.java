/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMethod;
import eapli.expensemanager.persistence.PaymentMethodRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    static List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
    static Cash cashEur = new Cash(Cash.EUR);
    
    static {
        paymentMethods.add(cashEur);
    }
    
    @Override
    public List<PaymentMethod> all() {
        return paymentMethods;
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        // TODO check if we alreay know this object or add it if not
        paymentMethods.add(paymentMethod);
        return paymentMethod;
    }

    @Override
    public Cash getCash(String EUR) {
        return cashEur;
    }
    
}
