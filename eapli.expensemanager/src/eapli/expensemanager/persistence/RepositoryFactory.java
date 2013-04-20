/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

/**
 * an Abstract Factory for the persistence layer
 * 
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    CheckingAccountRepository checkingAccountRepository();

    ExpenseRepository expenseRepository();

    ExpenseTypeRepository expenseTypeRepository();

    IncomeRepository incomeRepository();

    IncomeTypeRepository incomeTypeRepository();

    public PaymentMethodRepository paymentMethodRepository();
    
}
