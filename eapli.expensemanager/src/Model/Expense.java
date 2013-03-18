/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue
    long id;
    @ManyToOne 
    ExpenseType type;
    String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateOcurred;
    BigDecimal amount;
    
    protected Expense() {}
    
    public Expense(ExpenseType type, String description, Date dateOccurred, BigDecimal amount) {
        if (type == null || description == null || dateOccurred == null || amount == null) {
            throw new IllegalArgumentException();
        }
        // cannot record a negative expense or a zero EUR expense
        if (amount.signum() == -1 || amount.signum() ==  0) {
            throw new IllegalArgumentException();
        }
            
        this.type = type;
        this.description = description;
        this.dateOcurred = dateOccurred;
        this.amount = amount;
    }
    
    public Expense(ExpenseType type, String description, int year, int month, int day, BigDecimal amount) {
        this(type, description, DateTime.newDate(year, month, day), amount);
    }
    
    
    public BigDecimal getAmount() {
        return amount;
    }

    public boolean occursThisWeek() {
        int weekOfExpense = DateTime.weekNumber(dateOcurred);
        int thisWeek = DateTime.currentWeekNumber() ;
        return thisWeek == weekOfExpense;
    }

    public boolean occursThisMonth() {
        int thisMonth = DateTime.today().get(Calendar.MONTH);
        int expenseMonth = DateTime.dateToCalendar(dateOcurred).get(Calendar.MONTH);
        return (thisMonth == expenseMonth);
    }
}
