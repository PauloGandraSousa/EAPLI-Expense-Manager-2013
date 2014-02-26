/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.Expense;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The interface of the Expense repository.
 *
 * it was deprecated when the concept of CheckingAccount was introduced
 *
 * @author Paulo Gandra Sousa
 */
@Deprecated
public interface ExpenseRepository {

    /**
     * gets the total expenditure of a specific month
     *
     * note that this method is actualy placing the business logic in the
     * persistence code (e.g., SQL) which is normally something to avoid however
     * may be acceptable for performance reasons
     *
     * @param year
     * @param month
     * @return
     */
    BigDecimal expenditureOfMonth(int year, int month);

    /**
     * gets the expenditure of a specific week
     *
     * note that this method is actualy placing the business logic in the
     * persistence code (e.g., SQL) which is normally something to avoid however
     * may be acceptable for performance reasons
     *
     * @param year
     * @param weekNumber
     * @return
     */
    BigDecimal expenditureOfWeek(int year, int weekNumber);

    /**
     * persists an Expense (save or update)
     *
     * @param expense
     * @return the persistent object (may be a different object than the passed
     */
    Expense save(Expense expense);

    /**
     * gets the total amount of expenses
     *
     * note that this method is actualy placing the business logic in the
     * persistence code (e.g., SQL) which is normally something to avoid however
     * may be acceptable for performance reasons
     *
     * @return
     */
    BigDecimal totalExpenditure();

    /**
     * returns all the Expenses between two dates (inclusive)
     *
     * @param start
     * @param end
     * @return
     */
    List<Expense> between(Date start, Date end);

    /**
     * returns all the expenses
     *
     * @return
     */
    List<Expense> all();

    /**
     * returns the expenses with a certain tag
     *
     * @param tag
     * @return
     */
    List<Expense> getExpensesByTag(String tag);
}
