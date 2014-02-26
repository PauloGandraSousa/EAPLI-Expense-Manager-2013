/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMean;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import eapli.framework.persistence.jpa.JpaRepository;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PaymentMeanRepositoryImpl extends JpaRepository<PaymentMean, Long>
        implements PaymentMeanRepository {

    @Override
    public Cash getCash(String currency) {
        try {
            Query query = getEntityManager().createQuery(
                    "SELECT c FROM Cash c WHERE c.currency = :curr");
            query.setParameter("curr", currency);
            Cash cash = (Cash) query.getSingleResult();
            return cash;
        } catch (NoResultException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
