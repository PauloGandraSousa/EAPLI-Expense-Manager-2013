/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditCard extends Card {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreditCard() {
    }

    public CreditCard(String cardName, String bank, String cardNumber, String name, Calendar validUntil) {
        super(cardName, bank, cardNumber, name, validUntil);
    }

    @Override
    public String getDescription() {
        return "Credit Card" + cardName;
    }

    @Override
    public String toXml() {
        return "<creditCard>" + super.toXml() + "</creditCard>";
    }

    @Override
    public String toCsv() {
        return "CreditCard," + super.toCsv();
    }
}
