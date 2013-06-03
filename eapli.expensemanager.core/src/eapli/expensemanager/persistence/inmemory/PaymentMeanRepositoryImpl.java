/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMean;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PaymentMeanRepositoryImpl implements PaymentMeanRepository {

    static final List<PaymentMean> paymentMeans = new ArrayList<PaymentMean>();
    static final Cash cashEur = new Cash(Cash.EUR);
    
    static {
        paymentMeans.add(cashEur);
    }
    
    @Override
    public List<PaymentMean> all() {
        return paymentMeans;
    }

    @Override
    public PaymentMean save(PaymentMean paymentMethod) {
        // TODO check if we alreay know this object or add it if not
        paymentMeans.add(paymentMethod);
        return paymentMethod;
    }

    @Override
    public Cash getCash(String EUR) {
        return cashEur;
    }
    
}
