/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.hibernate;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class CheckingAccountRepositoryImpl extends HibernateRepository<CheckingAccount, Long> implements CheckingAccountRepository {
   
    @Override
    public CheckingAccount theAccount() {
        Collection<CheckingAccount> accounts = super.findAll();
        assert accounts.size() == 1;
        if (accounts.size() != 1) {
            throw new IllegalStateException();
        }
        Iterator<CheckingAccount> iterator = accounts.iterator();
        return iterator.next();
    }
}
