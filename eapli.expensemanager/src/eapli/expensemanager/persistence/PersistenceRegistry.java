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
    //SINGLETON
    private PersistenceRegistry() {}
    private static PersistenceRegistry instance = new PersistenceRegistry();
    public static PersistenceRegistry instance() { return instance;}
    
    public ExpenseRepository expenseRepository() {
        return new eapli.expensemanager.persistence.hibernate.ExpenseRepositoryImpl();
    }
    
    public ExpenseTypeRepository expenseTypeRepository() {
        return new eapli.expensemanager.persistence.hibernate.ExpenseTypeRepositoryImpl();
    }

    public IncomeRepository incomeRepository() {
        return new eapli.expensemanager.persistence.hibernate.IncomeRepositoryImpl();
    }

    public IncomeTypeRepository incomeTypeRepository() {
        return new eapli.expensemanager.persistence.hibernate.IncomeTypeRepositoryImpl();
    }

    public CheckingAccountRepository checkingAccountRepository() {
        return new eapli.expensemanager.persistence.hibernate.CheckingAccountRepositoryImpl();
    }
}
