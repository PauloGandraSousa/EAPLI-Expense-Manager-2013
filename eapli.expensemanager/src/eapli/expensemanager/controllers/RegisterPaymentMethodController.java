/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.Cheque;
import eapli.expensemanager.model.CreditCard;
import eapli.expensemanager.model.DebitCard;
import java.util.Calendar;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterPaymentMethodController extends BaseController {
    public void registerCreditCard(String cardName, String bank, String cardNumber, String name, Calendar validUntil) {
        CreditCard card = new CreditCard(cardName, bank, cardNumber, name, validUntil);
        card.save();
    }
    
    public void registerDebitCard(String cardName, String bank, String cardNumber, String name, Calendar validUntil) {
        DebitCard card = new DebitCard(cardName, bank, cardNumber, name, validUntil);
        card.save();
    }

    public void registerCheque(String chequeBookName, String bank, String accountNumber) {
        Cheque cheque = new Cheque(chequeBookName, bank, accountNumber);
        cheque.save();
    }
}
