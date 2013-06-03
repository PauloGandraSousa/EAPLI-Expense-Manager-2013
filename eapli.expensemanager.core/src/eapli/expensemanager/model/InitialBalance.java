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
    // TODO should this class be an inner class of the chekcingAccount instead of
    // a public class in the package

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TODO why does this class needs an Id?
    @Id
    @GeneratedValue
    Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date referenceDate = new Date();
    // TODO - verify if there are movements before this date
    BigDecimal initialValue;

    public InitialBalance() {
    }

    public InitialBalance(Date data, BigDecimal initialValue) {
        this.initialValue = initialValue;
        this.referenceDate = data;
    }

    public BigDecimal getValue() {
        return initialValue;
    }
}
