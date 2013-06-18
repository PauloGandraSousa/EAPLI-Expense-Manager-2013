/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRepositoryImpl extends JpaRepository<Expense, Long> implements ExpenseRepository {

    /**
     * gets the expenditure of a specific week
     *
     * note that this method is actualy placing the business logic in the HQL
     * code which is normally something to avoid
     *
     * @param year
     * @param weekNumber
     * @return
     */
    @Override
    public BigDecimal expenditureOfWeek(int year, int weekNumber) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT SUM(e.amount) FROM Expense e WHERE e.dateOcurred >= :start AND e.dateOcurred <= :end");
        Date start = DateTime.beginningOfWeek(year, weekNumber).getTime();
        q.setParameter("start", start);
        Date end = DateTime.endOfWeek(year, weekNumber).getTime();
        q.setParameter("end", end);

        BigDecimal balance = (BigDecimal) q.getSingleResult();
        if (balance == null) {
            balance = new BigDecimal(0);
        }
        return balance;
    }

    /**
     * gets the total expenditure of a specific month
     *
     * note that this method is actualy placing the business logic in the HQL
     * code which is normally something to avoid
     *
     * @param year
     * @param month
     * @return
     */
    @Override
    public BigDecimal expenditureOfMonth(int year, int month) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT SUM(e.amount) FROM Expense e WHERE e.dateOcurred >= :start AND e.dateOcurred <= :end");
        Date start = new Date(year - 1900, month - 1, 1);
        q.setParameter("start", start);
        Date end = new Date(year - 1900, month - 1, 31);
        q.setParameter("end", end);

        BigDecimal balance = (BigDecimal) q.getSingleResult();
        if (balance == null) {
            balance = new BigDecimal(0);
        }
        return balance;
    }

    /**
     * gets the total amount of expenses
     *
     * note that this method is actualy placing the business logic in the HQL
     * code which is normally something to avoid
     *
     * @return
     */
    @Override
    public BigDecimal totalExpenditure() {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT SUM(e.amount) FROM Expense e");
        BigDecimal balance = (BigDecimal) q.getSingleResult();
        if (balance == null) {
            balance = new BigDecimal(0);
        }
        return balance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Expense> between(Date start, Date end) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT e FROM Expense e WHERE e.dateOcurred >= :start AND e.dateOcurred <= :end");
        q.setParameter("start", start);
        q.setParameter("end", end);

        return q.getResultList();
    }
}
