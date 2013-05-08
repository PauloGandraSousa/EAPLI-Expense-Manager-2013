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

    public SavingPlan theSavingPlan();

    public SavingPlan save(SavingPlan savingPlan);
}
