/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.persistence.CheckingAccountRepository;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class CheckingAccountRepositoryImpl implements CheckingAccountRepository {

    static CheckingAccount theOneAndOnlyAccount = new CheckingAccount();

    @Override
    public CheckingAccount theAccount() {
        return theOneAndOnlyAccount;
    }

    @Override
    public CheckingAccount save(CheckingAccount account) {
        // make sure we receive the same object
        assert (account == theOneAndOnlyAccount);
        if (account != theOneAndOnlyAccount) {
            throw new IllegalStateException();
        }

        return theOneAndOnlyAccount;
    }
}
