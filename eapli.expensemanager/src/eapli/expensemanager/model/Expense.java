/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

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
public class Expense extends Movement {
    @ManyToOne 
    ExpenseType type;
    
    protected Expense() {}
    
    public Expense(ExpenseType type, String description, Date dateOccurred, BigDecimal amount) {
        super(description, dateOccurred, amount);
        this.type = type;
    }
    
    public Expense(ExpenseType type, String description, int year, int month, int day, BigDecimal amount) {
        this(type, description, DateTime.newDate(year, month, day), amount);
    }
}
