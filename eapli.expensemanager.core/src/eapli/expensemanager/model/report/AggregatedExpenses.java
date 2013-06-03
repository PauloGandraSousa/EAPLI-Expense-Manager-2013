/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.report;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author nuno
 */
public class AggregatedExpenses {

    ExpenseType expenseType = null;
    private BigDecimal sum = BigDecimal.ZERO;
    List<Expense> expenses = new ArrayList();

    /**
     * Add a movement to the list
     *
     * @param movement
     */
    public void aggregate(Expense expense) {
        expenses.add(expense);
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

    /**
     *
     * @param sum
     */
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
    private static final Logger LOG = Logger.getLogger(AggregatedExpenses.class.getName());
}
