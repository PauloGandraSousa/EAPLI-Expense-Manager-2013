/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.SavingPlan;

/**
 *
 * @author losa
 */
public interface SavingPlanRepository {

    /**
     * em termos conceptuais este objecto será um singleton. temos de garantir
     * que o retorno da base de dados será sempre um e apenas um objecto, daí o
     * nome theSavingPlan
     *
     * @return the one and only saving plan
     */
    SavingPlan theSavingPlan();

    SavingPlan save(SavingPlan savingPlan);
}
