/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.CheckingAccount;

/**
 * the interface for the Checking Account repository.
 *
 * this repository has some pecularities (e.g., the account) and as such does
 * not extend the genric Repository interface
 *
 * @author Paulo Gandra Sousa
 */
public interface CheckingAccountRepository /*extends Repository<CheckingAccount, Integer>*/ {

    /**
     * em termos conceptuais este objecto será um singleton. temos de garantir
     * que o retorno da base de dados será sempre um e apenas um objecto, daí o
     * nome theAccount
     *
     * @return the one and only account
     */
    CheckingAccount theAccount();

    CheckingAccount save(CheckingAccount account);
}
