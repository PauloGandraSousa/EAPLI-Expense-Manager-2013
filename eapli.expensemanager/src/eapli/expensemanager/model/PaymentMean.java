/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.persistence.ActiveRecord;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * base class for all means of payment, e.g., a specific credit card which is to
 * be considered different than payment method, e.g., credit card
 * 
 * this class hierarchy follows an Active Record pattern by having the load/save 
 * methods in the class' interface. in this case, controllers are NOT to call
 * the repository; the class will be responsible for calling the repository/DAO
 * 
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PaymentMean implements ActiveRecord, Serializable {
    @Id
    @GeneratedValue
    Long id;
    
    public PaymentMean() {
    }
    
    @Override
    public void save() {
        PaymentMeanRepository repo = PersistenceFactory.buildPersistenceFactory().paymentMeanRepository();
        repo.save(this);
    }
    
    public static List<PaymentMean> loadAll() {
        PaymentMeanRepository repo = PersistenceFactory.buildPersistenceFactory().paymentMeanRepository();
        return repo.all();
    }
    
    abstract public String getDescription() ;
    
    public abstract String toXml();
    
    public abstract String toCsv();
}
