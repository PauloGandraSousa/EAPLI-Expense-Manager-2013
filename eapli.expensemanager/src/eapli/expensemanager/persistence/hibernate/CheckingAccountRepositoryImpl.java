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
}
