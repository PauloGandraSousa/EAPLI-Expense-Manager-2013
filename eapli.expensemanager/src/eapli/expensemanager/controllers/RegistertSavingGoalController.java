/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.SavingGoal;
import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingPlanRepository;
import java.math.BigDecimal;

/**
 *
 * @author losa
 */
public class RegistertSavingGoalController extends BaseController {

    public void registerSavingGoal(String desctarget, BigDecimal totaltargetammount) {
        SavingPlanRepository repo;

        repo = PersistenceFactory.buildPersistenceFactory().savingPlanRepository();

        SavingGoal savingGoal = new SavingGoal(desctarget, totaltargetammount);

        SavingPlan savingsplan = repo.theSavingPlan();
        savingsplan.registerSavingGoal(savingGoal);
        repo.save(savingsplan);
    }
}
