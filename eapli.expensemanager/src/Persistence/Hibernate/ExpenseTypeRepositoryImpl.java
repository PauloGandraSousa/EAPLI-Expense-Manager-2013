/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Hibernate;

import Model.ExpenseType;
import Persistence.ExpenseTypeRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryImpl extends HibernateRepository implements ExpenseTypeRepository {
    @Override
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

    @Override
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

    @Override
    public List<ExpenseType> all() {
        EntityManager em = getEntityManager();
        assert em != null;

        Query q = em.createQuery("SELECT et FROM ExpenseType et");
        List<ExpenseType> expenseTypes = q.getResultList();
        return expenseTypes;
    }
}
