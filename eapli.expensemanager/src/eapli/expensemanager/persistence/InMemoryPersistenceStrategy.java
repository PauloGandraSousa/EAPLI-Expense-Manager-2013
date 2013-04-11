/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

/**
 *
 * @author Paulo Gandra Sousa
 */
  class InMemoryPersistenceStrategy implements PersistenceStrategy {

        @Override
        public ExpenseRepository expenseRepository() {
            return new eapli.expensemanager.persistence.inmemory.ExpenseRepositoryImpl();
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
    }