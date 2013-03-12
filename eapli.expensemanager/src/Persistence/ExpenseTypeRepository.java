/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.ExpenseType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepository extends Repository {
    public void save(ExpenseType expenseType) {
        if (expenseType == null) {
            throw new IllegalArgumentException();
        }

        EntityManager em = getEntityManager();
        assert em != null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(expenseType);
        tx.commit();
        em.close();
    }

    public ExpenseType findOrCreate(String key, String description) {
        if (key == null || key.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        
        EntityManager em = getEntityManager();
        assert em != null;

        ExpenseType expenseType;
        Query q = em.createQuery("SELECT et FROM ExpenseType et WHERE et.id = :type").setParameter("type", key);
        try {
            expenseType = (ExpenseType) q.getSingleResult();
        }
        catch (NoResultException ex)
        {
            expenseType = new ExpenseType(key, description);
            save(expenseType);           
        }
        return expenseType;
    }
}
