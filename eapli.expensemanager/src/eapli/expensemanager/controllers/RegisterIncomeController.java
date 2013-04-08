/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Income;
import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterIncomeController extends BaseController {

    public void registerIncome(String what, Date date, BigDecimal amount, IncomeType type) {
        Income income = new Income(what, date, amount, type);
        //IncomeRepository repo = PersistenceRegistry.instance().incomeRepository();
        CheckingAccountRepository repo = PersistenceRegistry.instance().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();
        account.registerIncome(income);
        repo.save(account);
    }
        
    public List<IncomeType> getIncomeTypes() {
        // use existing controller to avoid duplication
        ListIncomeTypesController listIncomeTypesController = new ListIncomeTypesController();
        return listIncomeTypesController.getIncomeTypes();
    }
}
