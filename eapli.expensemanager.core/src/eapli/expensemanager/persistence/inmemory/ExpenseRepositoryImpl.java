/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.persistence.ExpenseRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRepositoryImpl extends InMemoryRepositoryBase<Expense, Long> implements ExpenseRepository {

    //static List<Expense> expenses = new ArrayList<Expense>();
    @Override
    protected List<Expense> getStaticStore() {
        //return expenses;

        // use the checking account list as the rest of the program uses CheckingAccount
        return CheckingAccountRepositoryImpl.theOneAndOnlyAccount.getExpenses();
    }

    @Override
    public BigDecimal expenditureOfMonth(int year, int month) {
        BigDecimal sum = new BigDecimal(0);
        for (Expense one : getStaticStore()) {
            if (one.ocurredInMonth(year, month)) {
                sum = sum.add(one.getAmount());
            }
        }
        return sum;
    }

    @Override
    public BigDecimal expenditureOfWeek(int year, int weekNumber) {
        BigDecimal sum = new BigDecimal(0);
        for (Expense one : getStaticStore()) {
            if (one.ocurredInWeek(year, weekNumber)) {
                sum = sum.add(one.getAmount());
            }
        }
        return sum;
    }

    @Override
    public BigDecimal totalExpenditure() {
        BigDecimal sum = new BigDecimal(0);
        for (Expense one : getStaticStore()) {
            sum = sum.add(one.getAmount());
        }
        return sum;
    }

    @Override
    public List<Expense> between(Date start, Date end) {
        List<Expense> collected = new ArrayList<Expense>();
        for (Expense one : getStaticStore()) {
            if (one.occursBetween(start, end)) {
                collected.add(one);
            }
        }
        return collected;
    }

    @Override
    protected boolean matches(Expense entity, Long id) {
        return entity.is(id);
    }

    @Override
    public List<Expense> getExpensesByTag(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
