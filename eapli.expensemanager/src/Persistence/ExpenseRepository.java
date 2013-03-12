/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Expense;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRepository extends Repository {
    
    public void save(Expense expense) {
        EntityManager em = getEntityManager();
        assert em != null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(expense);
        tx.commit();
        em.close();
    }

    /**
     * gets the expenditure of a specific week
     * 
     * note that this method is actualy placing the business logic in the HQL code
     * which is normally something to avoid
     * 
     * @param year
     * @param weekNumber
     * @return
     */
    public BigDecimal expenditureOfWeek(int year, int weekNumber) {
        EntityManager em  = getEntityManager();
        Query q = em.createQuery("SELECT SUM(e.amount) FROM Expense e WHERE e.dateOcurred >= :start AND e.dateOcurred <= :end");
        Date start = DateTime.firstDateOfWeek(year, weekNumber).getTime();
        q.setParameter("start", start);
        Date end = DateTime.lastDateOfWeek(year, weekNumber).getTime();
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
     * note that this method is actualy placing the business logic in the HQL code
     * which is normally something to avoid
     * 
     * @param year
     * @param month
     * @return 
     */
    public BigDecimal expenditureOfMonth(int year, int month) {
        EntityManager em  = getEntityManager();
        Query q = em.createQuery("SELECT SUM(e.amount) FROM Expense e WHERE e.dateOcurred >= :start AND e.dateOcurred <= :end");
        Date start = new Date(year-1900, month-1, 1);
        q.setParameter("start", start);
        Date end = new Date(year-1900, month-1, 31);
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
     * note that this method is actualy placing the business logic in the HQL code
     * which is normally something to avoid
     * 
     * @return 
     */
    public BigDecimal totalExpenditure() {
        EntityManager em  = getEntityManager();
        Query q = em.createQuery("SELECT SUM(e.amount) FROM Expense e");
        BigDecimal balance = (BigDecimal) q.getSingleResult();
        if (balance == null) {
            balance = new BigDecimal(0);
        }
        return balance;
    }
}
