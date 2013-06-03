/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;

/**
 *
 * @author nuno
 */
public class AggregatedExpenses {

    private BigDecimal sum = BigDecimal.ZERO;
    List<Expense> expenses = new ArrayList<Expense>();

    /**
     * Add a movement to the list
     *
     * @param movement
     */
    public void aggregate(Expense expense) {
        expenses.add(expense);
        sum = sum.add(expense.getAmount());
    }

    /**
     * Returns all movements
     */
    public List<Expense> all() {
        return Collections.unmodifiableList(expenses);
    }

    /*
     * Returns the sum of all movements
     */
    /**
     *
     * @return
     */
    public BigDecimal getSum() {
        return sum;
    }
}
