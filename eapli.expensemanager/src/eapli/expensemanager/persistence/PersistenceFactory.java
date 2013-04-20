/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

/**
 * the factory class for the perisstence abstarcat factory hierarchy
 * 
 * @author Paulo Gandra Sousa
 */
public class PersistenceFactory {
    
    private PersistenceFactory() {
    }

    public static RepositoryFactory buildPersistenceFactory() {
        return new HibernateRepositoryFactory();
        // TODO use configuration property to decide which strategy to use
        //return new InMemoryPersistenceStrategy();
    }
}
