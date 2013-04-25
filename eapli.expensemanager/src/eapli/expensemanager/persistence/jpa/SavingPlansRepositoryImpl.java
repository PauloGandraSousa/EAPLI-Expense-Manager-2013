/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.SavingsPlan;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class SavingPlansRepositoryImpl extends JpaRepository<SavingsPlan, Long> implements eapli.expensemanager.persistence.SavingsPlanRepository {

    /**
     * @exception IllegalStateException Esta exceção é uma runtime exception.
     * Como tal, a partir da versão 5.0 do J2SE não é necessário efectuar o
     * throws da exceção na declaração do método
     * @return
     */
    @Override
    public SavingsPlan theSavingsPlan() {
        Collection<SavingsPlan> savingsplan = super.findAll();

        //valida que o retorno da base de dados será sempre apenas um e só um objecto
        assert savingsplan.size() == 1;

        //caso seja retornado mais do que um objecto, então lançar uma exceção
        if (savingsplan.size() != 1) {
            throw new IllegalStateException();
        }

        //caso apenas tenha sido retornado um objecto, obter esse objecto e retorná-lo 
        Iterator<SavingsPlan> iterator = savingsplan.iterator();
        return iterator.next();
    }
}
