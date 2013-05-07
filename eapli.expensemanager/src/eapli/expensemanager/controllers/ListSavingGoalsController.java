/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.SavingGoal;
import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingPlanRepository;
import java.util.List;

/**
 *
 * @author AJS
 */
public class ListSavingGoalsController extends BaseController 
{

    public List<SavingGoal> getSavingGoals() 
    {
        SavingPlanRepository repo = PersistenceFactory.buildPersistenceFactory().savingPlanRepository();
        SavingPlan savingPlan = repo.theSavingPlan(); 
        return savingPlan.getSavingGoals();
    }    

    
}
