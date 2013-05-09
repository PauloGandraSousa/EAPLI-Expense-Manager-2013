/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Card extends PaymentMean {
    String cardName;
    String bank;
    String cardNumber;
    String nameOnCard;
    @Temporal(javax.persistence.TemporalType.DATE)
    Calendar validUntil;

    public Card() {
    }
    
    public Card(String cardName, String bank, String cardNumber, String nameOnCard, Calendar validUntil) {
        // TODO perform validations
        
        this.cardName = cardName;
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.validUntil = validUntil;        
    }
       
    @Override
    public String toXml() {
        return "<cardName>" + cardName + "</cardName>" +
                "<bank>" + bank + "</bank>" +
                "<cardNumber>" + cardNumber + "</cardNumber>" +
                "<nameOnCard>" + nameOnCard + "</nameOnCard>" +
                "<validUntil>" + calendarToString(validUntil) + "</validUntil>";
    }
     
    private String calendarToString(Calendar cal) {
        String dateString = cal.get(Calendar.DAY_OF_MONTH) + "-";
        dateString += cal.get(Calendar.MONTH)+1 + "-";
        dateString += cal.get(Calendar.YEAR);
        return dateString;
    }
    
    @Override
    public String toCsv() {
        return cardName + "," +
                bank + "," +
                cardNumber + "," +
                nameOnCard + "," +
                calendarToString(validUntil) + ",,,";
    }

}
