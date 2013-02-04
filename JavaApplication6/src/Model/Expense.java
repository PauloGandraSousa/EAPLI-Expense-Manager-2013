/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import eapli.util.DateTime;
import eapli.util.Math;
import java.math.BigDecimal;
import java.util.Calendar;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class Expense {
    ExpenseType type;
    String description;
    CalendarDate dateOccurred;
    BigDecimal amount;
    
    public BigDecimal getAmount() {
        return amount;
    }

    public boolean occursThisWeek() {
        int weekOfExpense = DateTime.weekNumber(dateOccurred);
        return DateTime.currentWeekNumber() == weekOfExpense;
    }

    public boolean occursThisMonth() {
        return (DateTime.today().getMonth() == dateOccurred.getMonth());
    }
}
