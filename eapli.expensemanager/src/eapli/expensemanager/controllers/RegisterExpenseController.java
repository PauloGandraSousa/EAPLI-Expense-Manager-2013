/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseRepository;
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
        ExpenseRepository repo = PersistenceRegistry.instance().expenseRepository();
        repo.save(expense);
    }

    // TODO removed duplicated method also present in ListExpenseTypesController
    public List<ExpenseType> getExpenseTypes() {
        ExpenseTypeRepository repo = PersistenceRegistry.instance().expenseTypeRepository();
        return repo.all();
    }
}
