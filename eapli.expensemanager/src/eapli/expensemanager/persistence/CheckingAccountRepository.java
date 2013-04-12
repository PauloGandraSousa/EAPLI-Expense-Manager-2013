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

    /**
     * Quando uma classe é persistente, temos de garantir que o retorno da base
     * de dados será sempre um e apenas um objecto, daí o nome theAccount
     *
     * @return the one and only accountƒ
     */
    public CheckingAccount theAccount();

    public CheckingAccount save(CheckingAccount account);
}
