/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.SavingGoal;
import eapli.expensemanager.model.SavingsPlan;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingsPlanRepository;
import java.math.BigDecimal;

/**
 *
 * @author losa
 */
public class RegisterTargetSavingController extends BaseController {

    public void registerTargetSaving(String desctarget, BigDecimal totaltargetammount) {
        SavingsPlanRepository repo;

        repo = PersistenceFactory.buildPersistenceFactory().savingsPlanRepository();

        SavingGoal savingGoal = new SavingGoal(desctarget, totaltargetammount);

        SavingsPlan savingsplan = repo.theSavingsPlan();
        savingsplan.registerSavingGoal(savingGoal);
        repo.save(savingsplan);
    }
}
