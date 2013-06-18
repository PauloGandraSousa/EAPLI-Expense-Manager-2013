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
public class PaymentMeanRepositoryImpl extends InMemoryRepositoryBase<PaymentMean, Long> implements PaymentMeanRepository {

    static final List<PaymentMean> paymentMeans = new ArrayList<PaymentMean>();
    static final Cash cashEur = new Cash(Cash.EUR);

    static {
        paymentMeans.add(cashEur);
    }

    @Override
    public Cash getCash(String EUR) {
        return cashEur;
    }

    @Override
    protected List<PaymentMean> getStaticStore() {
        return paymentMeans;
    }

    @Override
    protected boolean matches(PaymentMean entity, Long id) {
        return entity.is(id);
    }
}
