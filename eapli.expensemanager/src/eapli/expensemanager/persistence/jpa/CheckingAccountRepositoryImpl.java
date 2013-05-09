/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class CheckingAccountRepositoryImpl extends JpaRepository<CheckingAccount, Long> implements CheckingAccountRepository {

    /**
     * @exception IllegalStateException Esta exceção é uma runtime exception.
     * Como tal, a partir da versão 5.0 do J2SE não é necessário efectuar o
     * throws da exceção na declaração do método
     * @return
     */
    @Override
    public CheckingAccount theAccount() {
        Collection<CheckingAccount> accounts = super.findAll();

        //valida que o retorno da base de dados será sempre apenas um e só um objecto
        assert accounts.size() == 1;

        //caso seja retornado mais do que um objecto, então lançar uma exceção
        if (accounts.size() != 1) {
            throw new IllegalStateException();
        }

        //caso apenas tenha sido retornado um objecto, obter esse objecto e retorná-lo 
        Iterator<CheckingAccount> iterator = accounts.iterator();
        return iterator.next();
    }

    public CheckingAccount save(CheckingAccount account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }

        EntityManager em = getEntityManager();
        assert em != null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (account.hasId()) {
            account = update(account);
        } else {
            account = create(account);
        }
        tx.commit();
        em.close();

        return account;
    }
}
