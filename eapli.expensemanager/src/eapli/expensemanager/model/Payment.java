/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Payment {
    @Id
    @GeneratedValue
    long id;
    
    @ManyToOne
    PaymentMethod method;

    public Payment() {}
    
    public Payment(PaymentMethod method) {
        this.method = method;
    }
}
