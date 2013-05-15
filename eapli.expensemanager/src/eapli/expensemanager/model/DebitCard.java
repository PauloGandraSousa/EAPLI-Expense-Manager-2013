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
public class DebitCard extends Card {

    public DebitCard() {
    }

    public DebitCard(String cardName, String bank, String cardNumber, String name, Calendar validUntil) {
        super(cardName, bank, cardNumber, name, validUntil);
    }

    @Override
    public String getDescription() {
        return "debit Card" + cardName;
    }

    @Override
    public String toXml() {
        return "<debitCard>" + super.toXml() + "</debitCard>";
    }

    @Override
    public String toCsv() {
        return "DebitCard," + super.toCsv();
    }
}
