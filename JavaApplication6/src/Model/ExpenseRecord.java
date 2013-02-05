/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRecord {
    List<Expense> theExpenses = new ArrayList<Expense>();
    BigDecimal thisWeekBalance;
    BigDecimal thisMonthBalance;
            
    public void register(Expense expense) {
        theExpenses.add(expense);
        updateBalances(expense);
    }

    private void updateBalances(Expense expense) {
        if (expense.occursThisWeek()) {
            thisWeekBalance.add(expense.getAmount());
        }
        if (expense.occursThisMonth()) {
            thisMonthBalance.add(expense.getAmount());
        }
    }

    public BigDecimal getThisWeekBalance() {
        return thisWeekBalance;
    }
    
    public BigDecimal getThisMonthBalance() {
        return thisMonthBalance;
    }
    
    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Expense expense : theExpenses)
            total.add(expense.getAmount());
        return total;
    }
}
