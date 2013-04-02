/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.CheckingAccount;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface CheckingAccountRepository {
    
    /***
     * 
     * @return the one and only account
     */
    public CheckingAccount theAccount();

    public CheckingAccount save(CheckingAccount account);
}
