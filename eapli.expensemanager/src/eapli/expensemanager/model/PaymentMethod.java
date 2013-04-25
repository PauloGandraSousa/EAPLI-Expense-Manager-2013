/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.persistence.ActiveRecord;
import eapli.expensemanager.persistence.PaymentMethodRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * base class for all payment methods
 * 
 * this class hierarchy follows an Active Record pattern by having the load/save 
 * methods in the class' interface. in this case, controllers are NOT to call
 * the repository; the class will be responsible for calling the repository/DAO
 * 
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PaymentMethod implements ActiveRecord {
    @Id
    @GeneratedValue
    Long id;
    
    public PaymentMethod() {
    }
    
    @Override
    public void save() {
        PaymentMethodRepository repo = PersistenceFactory.buildPersistenceFactory().paymentMethodRepository();
        repo.save(this);
    }
    
    public static List<PaymentMethod> loadAll() {
        PaymentMethodRepository repo = PersistenceFactory.buildPersistenceFactory().paymentMethodRepository();
        return repo.all();
    }
    
    abstract public String getDescription() ;
}
