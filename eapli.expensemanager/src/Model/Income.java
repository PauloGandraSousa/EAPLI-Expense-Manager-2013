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

}
