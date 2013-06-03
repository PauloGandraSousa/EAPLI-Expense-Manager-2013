/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.report;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author nuno
 */
public class ExpensesReport {

    Map<ExpenseType, AggregatedExpenses> aggregatedExpensesPerType = new HashMap<ExpenseType, AggregatedExpenses>();

    private AggregatedExpenses getAggregatedExpenses(ExpenseType expenseType) {

        AggregatedExpenses aggregatedMovements = aggregatedExpensesPerType.get(expenseType);
        if (aggregatedMovements == null) {
            aggregatedMovements = new AggregatedExpenses();
            aggregatedExpensesPerType.put(expenseType, aggregatedMovements);
        }
        return aggregatedMovements;
    }

    //TODO: check why there is no MovementType in Movement and then change or not to Movement
    /**
     *
     * @param expense
     */
    public void aggregate(Expense expense) {
        ExpenseType expenseType = expense.getExpenseType();
        AggregatedExpenses aggregatedExpenses = getAggregatedExpenses(expenseType);
        aggregatedExpenses.aggregate(expense);
    }

    /**
     *
     * @param expenseType
     * @param sum
     */
    public void setAggregatedSum(ExpenseType expenseType, BigDecimal sum) {
        AggregatedExpenses aggregatedMovements = getAggregatedExpenses(expenseType);
        aggregatedMovements.setSum(sum);
    }

    /**
     *
     * @return
     */
    public Map<ExpenseType, AggregatedExpenses> getAggregatedExpensesPerType() {
        return Collections.unmodifiableMap(aggregatedExpensesPerType);
    }
    private static final Logger LOG = Logger.getLogger(ExpensesReport.class.getName());
}
