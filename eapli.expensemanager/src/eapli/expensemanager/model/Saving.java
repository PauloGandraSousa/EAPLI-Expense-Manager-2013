/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author losa
 */
@Entity
public class Saving {
    
    @Id
    @GeneratedValue
    private long id;
    
    BigDecimal goalAmmount;
    String description;
    
    Saving () {}
    
    Saving ( String desc,BigDecimal ammount)
    {
        desc=description;
        goalAmmount=ammount;
        
    }
}
