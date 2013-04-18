/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.persistence.PaymentMethodRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cash extends PaymentMethod {
    String currency;

    public static final String EUR = "EUR";
    
    public Cash() {
    }
    
    public Cash(String currency) {
        // may allow null if the currency is not important
        this.currency = currency;
    }
    
    public static Cash loadEUR() {
        PaymentMethodRepository repo = PersistenceRegistry.instance().paymentMethodRepository();
        return repo.getCash(EUR);
    }
    
    @Override
    public String getDescription() {
        return "Cash " + currency;
    }
}
