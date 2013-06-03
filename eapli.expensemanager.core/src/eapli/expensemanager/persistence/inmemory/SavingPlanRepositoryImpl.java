/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.persistence.SavingPlanRepository;

/**
 *
 * @author losa
 */
public class SavingPlanRepositoryImpl implements SavingPlanRepository {

    static SavingPlan theOneAndOnlySavingPlan = new SavingPlan();

    @Override
    public SavingPlan theSavingPlan() {
        return theOneAndOnlySavingPlan;
    }

    @Override
    public SavingPlan save(SavingPlan savingsplan) {
        // make sure we receive the same object
        assert (savingsplan == theOneAndOnlySavingPlan);
        if (savingsplan != theOneAndOnlySavingPlan) {
            throw new IllegalStateException();
        }

        return theOneAndOnlySavingPlan;
    }
    
}
