/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class Repository {
    @PersistenceUnit
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("eapli.expensemanagerPU");
    
    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
