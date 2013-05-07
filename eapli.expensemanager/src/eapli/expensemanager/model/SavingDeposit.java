/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author AJS
 */
@Entity
public class SavingDeposit extends Movement 
{
    
    protected SavingDeposit() 
    {}
    
    public SavingDeposit(String description, Date dateOccurred, BigDecimal amount) 
    {
        super(description, dateOccurred, amount);
    }
    
    public SavingDeposit(String description, int year, int month, int day, BigDecimal amount) 
    {
        this(description, DateTime.newDate(year, month, day), amount);
    }
}
