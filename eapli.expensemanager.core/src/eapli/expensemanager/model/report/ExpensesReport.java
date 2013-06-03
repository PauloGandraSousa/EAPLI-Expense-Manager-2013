/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.report;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;

/**
 * 
 * @author nuno
 */
public class ExpensesReport {

	Map<ExpenseType, AggregatedExpenses> aggregatedExpensesPerType = new HashMap<ExpenseType, AggregatedExpenses>();

	private AggregatedExpenses getAggregatedExpenses(ExpenseType expenseType) {

		AggregatedExpenses aggregatedMovements = aggregatedExpensesPerType
				.get(expenseType);
		if (aggregatedMovements == null) {
			aggregatedMovements = new AggregatedExpenses();
			aggregatedExpensesPerType.put(expenseType, aggregatedMovements);
		}
		return aggregatedMovements;
	}

	// TODO: check why there is no MovementType in Movement and then change or
	// not to Movement
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
	 * @return
	 */
	public Map<ExpenseType, AggregatedExpenses> getAggregatedExpensesPerType() {
		return Collections.unmodifiableMap(aggregatedExpensesPerType);
	}
}
