/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Expense;
import Model.ExpenseRecord;
import Model.ExpenseType;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRegisterController {

    public ExpenseRegisterController() {
    }

    public void registerExpense(String what, Date date, BigDecimal amount, ExpenseType expenseType) {
        Expense expense = new Expense(expenseType, what, date, amount);
        ExpenseRecord.instance().register(expense);
    }
    
}
