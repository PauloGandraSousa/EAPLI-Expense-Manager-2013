package eapli.expensemanager.bootstrap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;

/**
 *
 * @author Paulo Gandra Sousa
 */
class Bootstrap {
    public Bootstrap() {
        ensureTheAccountExists();
    }

    private void ensureTheAccountExists() {
        CheckingAccountRepository repo = PersistenceRegistry.instance().checkingAccountRepository();
        try {
            CheckingAccount theAccount = repo.theAccount();
        }
        catch (IllegalStateException ex) {
            CheckingAccount theAccount = new CheckingAccount();
            repo.save(theAccount);
        }
    }
}
