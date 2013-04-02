/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRecord {
    List<Expense> theExpenses;
    
    public ExpenseRecord(List<Expense> expenses) {
        theExpenses = expenses;
    }
            
    public BigDecimal getExpenditure() {
        BigDecimal expenditure = new BigDecimal(0);
        for (Expense e : theExpenses) {
            expenditure = expenditure.add(e.getAmount());
        }
        return expenditure;
    }
}
