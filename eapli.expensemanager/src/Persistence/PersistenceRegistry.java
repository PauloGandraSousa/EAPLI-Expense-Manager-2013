/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class PersistenceRegistry {
    //SINGLETON
    private PersistenceRegistry() {}
    private static PersistenceRegistry instance = new PersistenceRegistry();
    public static PersistenceRegistry instance() { return instance;}
    
    public ExpenseRepository expenseRepository() {
        return new Persistence.Hibernate.ExpenseRepositoryImpl();
    }
    
    public ExpenseTypeRepository expenseTypeRepository() {
        return new Persistence.Hibernate.ExpenseTypeRepositoryImpl();
    }
}
