/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.SavingsPlan;
import eapli.expensemanager.persistence.SavingsPlanRepository;

/**
 *
 * @author losa
 */
public class SavingsPlanRepositoryImpl implements SavingsPlanRepository {

    static SavingsPlan theOneAndOnlySavingsPlan = new SavingsPlan();

    @Override
    public SavingsPlan theSavingsPlan() {
        return theOneAndOnlySavingsPlan;
    }

    @Override
    public SavingsPlan save(SavingsPlan savingsplan) {
        // make sure we receive the same object
        assert (savingsplan == theOneAndOnlySavingsPlan);
        if (savingsplan != theOneAndOnlySavingsPlan) {
            throw new IllegalStateException();
        }

        return theOneAndOnlySavingsPlan;
    }
}
