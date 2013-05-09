/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.util.Validations;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cheque extends PaymentMean {

    String chequeBooksName;
    String bank;
    String accountNumber;

    protected Cheque() {}
    
    public Cheque(String chequeBooksName, String bank, String accountNumber) {
        super();

        if (Validations.isNullOrEmpty(chequeBooksName) || 
                Validations.isNullOrEmpty(bank) || 
                Validations.isNullOrEmpty(accountNumber)) {
            throw new IllegalArgumentException();
        }
        
        this.chequeBooksName = chequeBooksName;
        this.accountNumber = accountNumber;
        this.bank = bank;
    }

    @Override
    public String getDescription() {
        return "Cheque " + chequeBooksName;
    }
        
    public String toXml() {
        return "<bank>" + bank + "</bank><accountNumber>" +
                accountNumber +  "</accountNumber>";
    }
    
    public String toCsv() {
        return "Cheque,," + bank + ",,,," + accountNumber +  ",";
    }
}
