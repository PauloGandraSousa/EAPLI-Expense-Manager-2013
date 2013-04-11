/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PersistenceRegistry {
    private PersistenceRegistry() {
    }

    public static PersistenceStrategy instance() {
        return new HibernatePersistenceStrategy();
        // TODO use configuration property to decide which strategy to use
        //return new InMemoryPersistenceStrategy();
    }
}
