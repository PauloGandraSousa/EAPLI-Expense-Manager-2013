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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ChequePayment extends Payment {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String chequeNumber;

    public ChequePayment() {
    }

    public ChequePayment(Cheque method, String chequeNumber) {
        super(method);
        this.chequeNumber = chequeNumber;
    }
}
