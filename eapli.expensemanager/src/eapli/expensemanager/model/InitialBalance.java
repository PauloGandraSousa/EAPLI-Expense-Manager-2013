/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author arocha
 */
@Entity
public class InitialBalance implements Serializable {
    // TODO why does class needs an Id?

    @Id
    @GeneratedValue
    Long id;
    // TODO "data" is not a meaningfull name in this context (at least in english ;-)
    // consider refactoring to "asOf" or "referenceDate"
    // FIX "data" is a SQL reserved keyword
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data = new Date();
    // TODO - verify if there are movements before this date
    BigDecimal initialValue;

    public InitialBalance() {
    }

    public InitialBalance(Date data, BigDecimal initialValue) {
        this.initialValue = initialValue;
        this.data = data;
    }

    public BigDecimal getValue() {
        return initialValue;
    }
}
