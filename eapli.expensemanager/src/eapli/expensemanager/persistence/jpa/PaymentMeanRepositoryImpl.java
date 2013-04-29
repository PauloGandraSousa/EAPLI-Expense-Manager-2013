/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMean;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PaymentMeanRepositoryImpl extends JpaRepository<PaymentMean, Long> implements PaymentMeanRepository {

    @Override
    public List<PaymentMean> all() {
        return super.all();
    }

    @Override
    public PaymentMean save(PaymentMean paymentMean) {
        return super.save(paymentMean);
    }

    @Override
    public Cash getCash(String currency) {
        Query query = getEntityManager().createQuery("SELECT c FROM Cash c WHERE c.currency = :curr");
        query.setParameter("curr", currency);
        Cash cash = (Cash)query.getSingleResult();
        return cash;
    }
    
}
