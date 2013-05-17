/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
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
public class Payment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    long id;
    
    @ManyToOne
    PaymentMean method;

    public Payment() {}
    
    public Payment(PaymentMean method) {
        this.method = method;
    }
    
    public String toXml() {
        return "<payment>" + method.toXml() + "</payment>";
    } 
    
    public String toCsv() {
        return method.toCsv();
    }
}
