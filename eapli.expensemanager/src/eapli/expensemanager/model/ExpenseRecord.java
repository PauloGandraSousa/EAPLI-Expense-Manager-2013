/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents a collection of expenses and all the business logic 
 * associated with Expenses (plural).
 * This collection is keep in memory only and should be reconstructed from 
 * persistence using the ExpenseRepository
 * 
 * It was deprecated when the concept of CheckingAccount was introduced as the 
 * Account is the root entity (aggregate) for all Expenses and Incomes
 * 
 * @author Paulo Gandra Sousa
 */
@Deprecated
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
