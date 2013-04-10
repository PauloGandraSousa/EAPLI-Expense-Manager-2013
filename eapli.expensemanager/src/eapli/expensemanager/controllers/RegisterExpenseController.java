/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterExpenseController extends BaseController {

    public RegisterExpenseController() {
    }

    public void registerExpense(String what, Date date, BigDecimal amount, ExpenseType expenseType) {
        Expense expense = new Expense(expenseType, what, date, amount);
        //ExpenseRepository repo = PersistenceRegistry.instance().expenseRepository();
        CheckingAccountRepository repo = PersistenceRegistry.instance().checkingAccountRepository();
        CheckingAccount account = repo.theAccount(); 
        account.registerExpense(expense);
        repo.save(account);
    }

    public List<ExpenseType> getExpenseTypes() {
        // use the existing controller to avoid duplication
        ListExpenseTypesController listExpenseTypesController = new ListExpenseTypesController();
        return listExpenseTypesController.getExpenseTypes();
    }
}
