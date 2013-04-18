/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cheque extends PaymentMethod {

    String chequeBooksName;
    String bank;
    String accountNumber;

    protected Cheque() {}
    
    public Cheque(String chequeBooksName, String bank, String accountNumber) {
        super();
        // FIX do validations
        this.chequeBooksName = chequeBooksName;
        this.accountNumber = accountNumber;
        this.bank = bank;
    }

    @Override
    public String getDescription() {
        return "Cheque " + chequeBooksName;
    }
}
