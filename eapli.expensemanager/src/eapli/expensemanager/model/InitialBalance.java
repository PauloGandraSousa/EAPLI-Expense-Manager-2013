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
public class InitialBalance implements Serializable{
    @Id
    @GeneratedValue
     Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data = new Date();
    // TODO - verify if there are movements before this date
    
     BigDecimal initialValue;

   public InitialBalance() {
    }

    public InitialBalance( Date data,BigDecimal initialValue) {
        this.initialValue = initialValue;
        this.data = data;
    }

    public BigDecimal getValue(){
        return initialValue;
    }
    

}

