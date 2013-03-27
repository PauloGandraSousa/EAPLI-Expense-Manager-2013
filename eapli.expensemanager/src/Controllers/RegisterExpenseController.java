/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Expense;
import Model.ExpenseType;
import Persistence.ExpenseRepository;
import Persistence.ExpenseTypeRepository;
import Persistence.PersistenceRegistry;
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
