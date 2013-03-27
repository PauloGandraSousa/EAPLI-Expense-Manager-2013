/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class Income {
    @Id
    @GeneratedValue
    long id;
    @ManyToOne 
    IncomeType type;
    String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateOcurred;
    BigDecimal amount;

    public Income(String description, Date dateOccurred, BigDecimal amount) {
        // TODO refactor with Expense
       if (description == null || dateOccurred == null || amount == null) {
            throw new IllegalArgumentException();
        }
        // cannot record a negative income or a zero EUR income
        if (amount.signum() == -1 || amount.signum() ==  0) {
            throw new IllegalArgumentException();
        }
            
        this.description = description;
        this.dateOcurred = dateOccurred;
        this.amount = amount;
    }
}
