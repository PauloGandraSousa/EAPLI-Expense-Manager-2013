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
 *
 * @author Paulo Gandra Sousa
 */
public interface ExpenseRepository {

    /**
     * gets the total expenditure of a specific month
     *
     * note that this method is actualy placing the business logic in the HQL code
     * which is normally something to avoid
     *
     * @param year
     * @param month
     * @return
     */
    BigDecimal expenditureOfMonth(int year, int month);

    /**
     * gets the expenditure of a specific week
     *
     * note that this method is actualy placing the business logic in the HQL code
     * which is normally something to avoid
     *
     * @param year
     * @param weekNumber
     * @return
     */
    BigDecimal expenditureOfWeek(int year, int weekNumber);

    void save(Expense expense);

    /**
     * gets the total amount of expenses
     *
     * note that this method is actualy placing the business logic in the HQL code
     * which is normally something to avoid
     *
     * @return
     */
    BigDecimal totalExpenditure();

    /**
     * 
     * @param start
     * @param end
     * @return 
     */
    public List<Expense> between(Date start, Date end);
    
    public List<Expense> all();
}
