/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterIncomeController extends BaseController {

    public void registerIncome(String what, Date date, BigDecimal amount) {
        Income income = new Income(what, date, amount);
        //IncomeRepository repo = PersistenceRegistry.instance().incomeRepository();
        CheckingAccountRepository repo = PersistenceRegistry.instance().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();
        account.registerIncome(income);
        repo.save(account);
    }
    
}
