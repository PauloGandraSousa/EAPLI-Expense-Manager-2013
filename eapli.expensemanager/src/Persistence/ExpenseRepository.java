/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Expense;
import javax.persistence.EntityManager;


/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRepository extends Repository {

    
    public void save(Expense expense) {
        EntityManager em = getEntityManager();
        assert em != null;
        em.persist(expense);
    }
}
