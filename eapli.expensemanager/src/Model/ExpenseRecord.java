/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistence.ExpenseRepository;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRecord {

    List<Expense> theExpenses = new ArrayList<Expense>();
    BigDecimal thisWeekBalance = new BigDecimal(0);
    BigDecimal thisMonthBalance = new BigDecimal(0);
    BigDecimal balance = new BigDecimal(0);

    // SINGLETON
    private ExpenseRecord() {
        loadBalances();
    }
    
    private static ExpenseRecord theInstance = null;

    public static ExpenseRecord instance() {
        if (theInstance == null) {
            theInstance = new ExpenseRecord();
        }
        return theInstance;
    }

    private void loadBalances() {
        ExpenseRepository repo = new ExpenseRepository();
        thisWeekBalance = repo.expenditureOfWeek(DateTime.currentYear(), DateTime.currentWeekNumber());
        thisMonthBalance = repo.expenditureOfMonth(DateTime.currentYear(), DateTime.currentMonth());
    }

    public void register(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException();
        }
        //theExpenses.add(expense);
        ExpenseRepository repo = new ExpenseRepository();
        repo.save(expense);
        updateBalances(expense);
    }

    private void updateBalances(Expense expense) {
        assert expense != null;
        assert balance != null;

        if (expense.occursThisWeek()) {
            thisWeekBalance = thisWeekBalance.add(expense.getAmount());
        }
        if (expense.occursThisMonth()) {
            thisMonthBalance = thisMonthBalance.add(expense.getAmount());
        }

        balance = balance.add(expense.getAmount());
    }

    public BigDecimal getThisWeekBalance() {
        return thisWeekBalance;
    }

    public BigDecimal getThisMonthBalance() {
        return thisMonthBalance;
    }

    public BigDecimal getTotal() {
//        BigDecimal total = new BigDecimal(0);
//        for (Expense expense : theExpenses) {
//            total = total.add(expense.getAmount());
//        }
//        return total;
        ExpenseRepository repo = new ExpenseRepository();
        BigDecimal total = repo.totalExpenditure();
        return total;
    }
}
