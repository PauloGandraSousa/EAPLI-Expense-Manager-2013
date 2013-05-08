/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.SavingDeposit;
import eapli.expensemanager.model.SavingGoal;
import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingPlanRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ajs
 */
public class RegisterSavingDepositController extends BaseController 
{

    public RegisterSavingDepositController() 
    {
    }

    public void registerSavingDeposit(SavingGoal goal, Date date, BigDecimal amount, String description) 
    {
        CheckingAccountRepository checkingAccountRepository = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount checkingAccount = checkingAccountRepository.theAccount(); 
        
        // FIX controllers shouldn't have business logic
        if(checkingAccount.enoughBalance(amount))
        {
            SavingDeposit savingDeposit = new SavingDeposit(description, date, amount);
            
            SavingPlanRepository savingPlanRepository = PersistenceFactory.buildPersistenceFactory().savingPlanRepository();
            SavingPlan savingPlan = savingPlanRepository.theSavingPlan(); 
        
            savingPlan.registerSavingDeposit(savingDeposit,goal);
            checkingAccount.registerSavingDeposit(savingDeposit);
                        
            savingPlanRepository.save(savingPlan);
            checkingAccountRepository.save(checkingAccount);
        }
    }

    public List<SavingGoal> getSavingGoals() 
    {
        return new ListSavingGoalsController().getSavingGoals();
    }
}

