/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import sun.util.calendar.CalendarDate;

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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean occursThisMonth() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
