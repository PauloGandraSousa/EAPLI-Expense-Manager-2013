/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import java.math.BigDecimal;
import java.util.Date;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.ExpenseRecord;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.framework.Controller;
import eapli.util.DateTime;

/**
 * the base controller class for all controllers
 * 
 * @author Paulo Gandra Sousa
 */
public abstract class BaseController implements Controller {

	/**
	 * gets the expenditure of the current week.
	 * 
	 * this method follows an "OO approach" by asking the repository to recreate
	 * the expense record of the desired week and performs the calculation in
	 * memory. doing the calculation in memory might not be as performant as
	 * doing it directly at the persistence layer but allows to apply business
	 * logic to the calculation, for instance, as a Strategy pattern
	 * 
	 * @return the total expenditure of the current week
	 */
	public BigDecimal getCurrentWeekExpenditure() {
		ExpenseRepository repo = PersistenceFactory.buildPersistenceFactory()
				.expenseRepository();
		int year = DateTime.currentYear();
		int week = DateTime.currentWeekNumber();
		Date start = DateTime.beginningOfWeek(year, week).getTime();
		Date end = DateTime.endOfWeek(year, week).getTime();

		ExpenseRecord expenseRecord = new ExpenseRecord(
				repo.between(start, end));
		return expenseRecord.getExpenditure();
	}

	/**
	 * gets the expenditure of the current month.
	 * 
	 * this methods relies on the repository to do the calculation. for
	 * performance reasons this type of aggregated calculations can be done
	 * directly by the database/persistence layer
	 * 
	 * @return the total expenditure of the current month
	 */
	public BigDecimal getCurrentMonthExpenditure() {
		ExpenseRepository repo = PersistenceFactory.buildPersistenceFactory()
				.expenseRepository();
		return repo.expenditureOfMonth(DateTime.currentYear(),
				DateTime.currentMonth());
	}

	/**
	 * gets the current balance.
	 * 
	 * @return
	 */
	public BigDecimal getBalance() {
		final CheckingAccountRepository repo = PersistenceFactory
				.buildPersistenceFactory().checkingAccountRepository();
		final CheckingAccount account = repo.theAccount();

		return account.getBalance();
	}
}
