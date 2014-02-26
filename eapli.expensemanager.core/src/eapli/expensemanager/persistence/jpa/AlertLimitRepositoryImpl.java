/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.framework.persistence.jpa.JpaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mcn
 */
public class AlertLimitRepositoryImpl extends JpaRepository<AlertLimit, Long> implements AlertLimitRepository {

    @Override
    public AlertLimit findById(Long key) {
        return super.read(key);
    }

    @Override
    public AlertLimit findByAlertType(AlertLimitType a) {
        EntityManager em = getEntityManager();
        Query q = em
                .createQuery("SELECT e FROM AlertLimit e WHERE e.alertType = :aLertT");
        q.setParameter("aLertT", a);
        @SuppressWarnings("unchecked")
        List<AlertLimit> list = q.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public AlertLimit findByExpenseType(ExpenseType eT) {

        EntityManager em = getEntityManager();
        Query q = em
                .createQuery("SELECT e FROM AlertLimitByExpenseType e WHERE e.expenseType= :eT");
        q.setParameter("eT", eT);
        @SuppressWarnings("unchecked")
        List<AlertLimit> list = q.getResultList();
        if (list.isEmpty()) {

            return null;
        }
        return list.get(0);
    }
}
