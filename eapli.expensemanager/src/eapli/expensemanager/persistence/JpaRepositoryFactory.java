/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

/**
 * a concrete factory - hibernate
 * 
 * @author Paulo Gandra Sousa
 */
class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public ExpenseRepository expenseRepository() {
        return new eapli.expensemanager.persistence.jpa.ExpenseRepositoryImpl();
    }

   
    @Override
    public ExpenseTypeRepository expenseTypeRepository() {
        return new eapli.expensemanager.persistence.jpa.ExpenseTypeRepositoryImpl();
    }

    @Override
    public IncomeRepository incomeRepository() {
        return new eapli.expensemanager.persistence.jpa.IncomeRepositoryImpl();
    }

    @Override
    public IncomeTypeRepository incomeTypeRepository() {
        return new eapli.expensemanager.persistence.jpa.IncomeTypeRepositoryImpl();
    }

    @Override
    public CheckingAccountRepository checkingAccountRepository() {
        return new eapli.expensemanager.persistence.jpa.CheckingAccountRepositoryImpl();
    }

    
    @Override
    public SavingsPlanRepository savingsPlanRepository() {
        return new eapli.expensemanager.persistence.jpa.SavingsPlanRepositoryImpl();
    }
    
    @Override
    public PaymentMeanRepository paymentMeanRepository() {
        return new eapli.expensemanager.persistence.jpa.PaymentMeanRepositoryImpl();
    }
}
