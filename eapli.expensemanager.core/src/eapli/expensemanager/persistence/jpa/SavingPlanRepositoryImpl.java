/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.framework.persistence.JpaRepository;
import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.persistence.SavingPlanRepository;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class SavingPlanRepositoryImpl extends JpaRepository<SavingPlan, Long> implements SavingPlanRepository {

    /**
     * @exception IllegalStateException Esta exceção é uma runtime exception.
     * Como tal, a partir da versão 5.0 do J2SE não é necessário efectuar o
     * throws da exceção na declaração do método
     * @return
     */
    @Override
    public SavingPlan theSavingPlan() {
        Collection<SavingPlan> savingplan = super.findAll();

        //valida que o retorno da base de dados será sempre apenas um e só um objecto
        assert savingplan.size() == 1;

        //caso seja retornado mais do que um objecto, então lançar uma exceção
        if (savingplan.size() != 1) {
            throw new IllegalStateException();
        }

        //caso apenas tenha sido retornado um objecto, obter esse objecto e retorná-lo 
        Iterator<SavingPlan> iterator = savingplan.iterator();
        return iterator.next();
    }

}