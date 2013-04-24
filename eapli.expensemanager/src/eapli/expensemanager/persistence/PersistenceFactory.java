/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.ExpenseManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * the factory class for the perisstence abstarcat factory hierarchy
 * 
 * @author Paulo Gandra Sousa
 */
public class PersistenceFactory {
    
    private PersistenceFactory() {
    }

    public static RepositoryFactory buildPersistenceFactory() {
        // TODO should the application properties exist in othe rclass than the 
        // ExpensEManager to avoid the dependency to that class?
        String factoryClassName = ExpenseManager.getApplicationProperties().getProperty("persistence.repositoryFactory");
        try {
            return (RepositoryFactory) Class.forName(factoryClassName).newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersistenceFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(PersistenceFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PersistenceFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
}
