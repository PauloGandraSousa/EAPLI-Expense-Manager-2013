/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import java.util.List;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.expensemanager.persistence.PersistenceFactory;

/**
 * 
 * @author Paulo Gandra Sousa
 */
public class ListExpensesController extends BaseController {
	/*
	 * public List<Expense> getExpenses() { ExpenseRepository repo =
	 * PersistenceFactory.buildPersistenceFactory().expenseRepository(); return
	 * repo.all(); }
	 */

	public List<Expense> getExpenses() {
		CheckingAccountRepository repo = PersistenceFactory
				.buildPersistenceFactory().checkingAccountRepository();
		CheckingAccount account = repo.theAccount();
		return account.getExpenses();
	}

	public List<Expense> getExpensesByTag(String tag) {
		ExpenseRepository repo = PersistenceFactory.buildPersistenceFactory()
				.expenseRepository();
		return repo.getExpensesByTag(tag);

	}
}
