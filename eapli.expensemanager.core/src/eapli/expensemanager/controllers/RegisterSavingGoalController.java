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
public class RegisterSavingGoalController extends BaseController {

    public void registerSavingGoal(String targetDescription, BigDecimal targetAmount) {
        SavingPlanRepository repo = PersistenceFactory.buildPersistenceFactory().savingPlanRepository();

        SavingGoal savingGoal = new SavingGoal(targetDescription, targetAmount);

        SavingPlan savingsplan = repo.theSavingPlan();
        savingsplan.registerSavingGoal(savingGoal);
        repo.save(savingsplan);
    }
}
