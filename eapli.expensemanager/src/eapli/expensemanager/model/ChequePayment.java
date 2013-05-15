/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ChequePayment extends Payment {

    private String chequeNumber;

    public ChequePayment() {
    }

    public ChequePayment(Cheque method, String chequeNumber) {
        super(method);
        this.chequeNumber = chequeNumber;
    }

    public String toXml() {
        return "<payment> + paymentMeans.toXml()"
                + "<chequeNumber> + chequeNumber + </chequeNumber></payment>";
    }

    public String toCsv() {
        return super.toCsv() + "," + chequeNumber;
    }
}
