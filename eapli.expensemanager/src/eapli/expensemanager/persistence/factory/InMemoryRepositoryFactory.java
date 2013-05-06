/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.factory;

import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.IncomeRepository;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import eapli.expensemanager.persistence.RepositoryFactory;
import eapli.expensemanager.persistence.SavingsPlanRepository;

/**
 * a concrete factory - in memory
 *
 * @author Paulo Gandra Sousa
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    @Override
    public ExpenseRepository expenseRepository() {
        return new eapli.expensemanager.persistence.inmemory.ExpenseRepositoryImpl();
    }

    @Override
    public SavingsPlanRepository savingsPlanRepository() {
        return new eapli.expensemanager.persistence.inmemory.SavingsPlanRepositoryImpl();
    }

    @Override
    public ExpenseTypeRepository expenseTypeRepository() {
        return new eapli.expensemanager.persistence.inmemory.ExpenseTypeRepositoryImpl();
    }

    @Override
    public IncomeRepository incomeRepository() {
        return new eapli.expensemanager.persistence.inmemory.IncomeRepositoryImpl();
    }

    @Override
    public IncomeTypeRepository incomeTypeRepository() {
        return new eapli.expensemanager.persistence.inmemory.IncomeTypeRepositoryImpl();
    }

    @Override
    public CheckingAccountRepository checkingAccountRepository() {
        return new eapli.expensemanager.persistence.inmemory.CheckingAccountRepositoryImpl();
    }

    @Override
    public PaymentMeanRepository paymentMeanRepository() {
        return new eapli.expensemanager.persistence.inmemory.PaymentMeanRepositoryImpl();
    }
}