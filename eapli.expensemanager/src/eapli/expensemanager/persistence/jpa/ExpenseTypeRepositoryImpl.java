/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryImpl extends JpaRepository<ExpenseType, String> implements ExpenseTypeRepository {

    @Override
    public ExpenseType findForName(String key) {
        return super.read(key);
    }
//    public ExpenseType findOrCreate(String key, String description) {
//        if (key == null || key.trim().length() == 0) {
//            throw new IllegalArgumentException();
//        }
//
//        EntityManager em = getEntityManager();
//        assert em != null;
//
//        ExpenseType expenseType;
//        Query q = em.createQuery("SELECT et FROM ExpenseType et WHERE et.id = :type").setParameter("type", key);
//        try {
//            expenseType = (ExpenseType) q.getSingleResult();
//        }
//        catch (NoResultException ex)
//        {
//            expenseType = new ExpenseType(key, description);
//            save(expenseType);
//        }
//        return expenseType;
//    }
}
