/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.AppExpenses;
import Model.Expense;
import Model.ExpenseRecord;
import Model.ExpenseType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRegisterController {

    public ExpenseRegisterController() {
    }

    public void registerExpense(String what, Date date, BigDecimal amount, String expenseTypeDescr) {
        ExpenseType expenseType = AppExpenses.getInstance().expenseTypes.getExpenseTypeByDescr(expenseTypeDescr);
        Expense expense = new Expense(expenseType, what, date, amount);
        ExpenseRecord.instance().register(expense);
    }

    public List<String> getExpenseTypes() {
        return AppExpenses.getInstance().expenseTypes.getExpenseTypes();
    }
}
