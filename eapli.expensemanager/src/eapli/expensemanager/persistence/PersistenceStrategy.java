/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface PersistenceStrategy {

    CheckingAccountRepository checkingAccountRepository();

    ExpenseRepository expenseRepository();

    ExpenseTypeRepository expenseTypeRepository();

    IncomeRepository incomeRepository();

    IncomeTypeRepository incomeTypeRepository();

    public PaymentMethodRepository paymentMethodRepository();
    
}
