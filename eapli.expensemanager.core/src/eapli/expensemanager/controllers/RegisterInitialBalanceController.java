/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.InitialBalance;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author arocha
 */
public class RegisterInitialBalanceController extends BaseController {

	public void registerInitialBalance(Date date, BigDecimal amount) {
		InitialBalance initial = new InitialBalance(date, amount);
		CheckingAccountRepository repo = PersistenceFactory
				.buildPersistenceFactory().checkingAccountRepository();
		CheckingAccount account = repo.theAccount();
		account.registerInitialBalance(initial);
		repo.save(account);
	}
}