/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class Income extends Movement {

    @ManyToOne(cascade = CascadeType.MERGE)
    IncomeType type;

    public Income() {
    }

    public Income(String description, Date dateOccurred, BigDecimal amount) {
        super(description, dateOccurred, amount);
    }
}
