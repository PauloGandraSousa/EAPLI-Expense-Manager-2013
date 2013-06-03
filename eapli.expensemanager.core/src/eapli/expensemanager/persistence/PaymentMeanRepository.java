/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.PaymentMean;
import java.util.List;

/**
 * The Data Acces Object (DAO) for the Payment Method Active Record
 *
 * For consistency purposes, this class keeps the Repository suffix even thou it
 * should be called PaymentMethodDAO
 *
 * @author Paulo Gandra Sousa
 */
public interface PaymentMeanRepository {

    List<PaymentMean> all();

    PaymentMean save(PaymentMean paymentMethod);

    Cash getCash(String currency);
}
