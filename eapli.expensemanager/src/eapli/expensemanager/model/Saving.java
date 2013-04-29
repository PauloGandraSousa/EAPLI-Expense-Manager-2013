/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author losa
 */
@Entity
public class Saving {
    @Id
    @GeneratedValue
    private Long id; 
    
    private BigDecimal ammount;

    Saving(){}
    public Saving(BigDecimal ammount)
    {
        this.ammount=ammount;
    }
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the ammount
     */
    public BigDecimal getAmmount() {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }
}
