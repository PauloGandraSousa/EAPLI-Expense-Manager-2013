/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.hibernate;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMethod;
import eapli.expensemanager.persistence.PaymentMethodRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PaymentMethodRepositoryImpl extends HibernateRepository<PaymentMethod, Long> implements PaymentMethodRepository {

    @Override
    public List<PaymentMethod> all() {
        return super.all();
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return super.save(paymentMethod);
    }

    @Override
    public Cash getCash(String currency) {
        Query query = getEntityManager().createQuery("FROM Cash c WHERE c.currency = :curr");
        query.setParameter("curr", currency);
        Cash cash = (Cash)query.getSingleResult();
        return cash;
    }
    
}
