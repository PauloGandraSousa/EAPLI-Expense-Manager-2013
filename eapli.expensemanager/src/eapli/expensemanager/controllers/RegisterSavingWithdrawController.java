/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.SavingGoal;
import java.util.List;

/**
 *
 * @author AJS
 */
public class RegisterSavingWithdrawController extends BaseController
{
    
    public List<SavingGoal> getSavingGoals() 
    {
        return new ListSavingGoalsController().getSavingGoals();
    }
    
}


