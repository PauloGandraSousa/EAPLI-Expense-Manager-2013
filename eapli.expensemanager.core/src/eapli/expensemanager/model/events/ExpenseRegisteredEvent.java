/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.events;

import java.math.BigDecimal;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;

/**
 *
 * @author mcn
 */
public class ExpenseRegisteredEvent {

    private final Expense expenseRegistered;

    public ExpenseRegisteredEvent(Expense expenseRegistered) {
        this.expenseRegistered = expenseRegistered;
    }

    public BigDecimal getAmount() {
        return expenseRegistered.getAmount();
    }

    private ExpenseType getExpenseType() {
        return expenseRegistered.getExpenseType();
    }

    public Expense getExpense() {
        return expenseRegistered;
    }
}
