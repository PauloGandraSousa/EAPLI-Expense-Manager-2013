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
import eapli.expensemanager.model.exceptions.InsufficientBalanceException;

/**
 *
 * @author ajs
 */
public class RegisterSavingDepositController extends BaseController {

    public RegisterSavingDepositController() {
    }

    public void registerSavingDeposit(SavingGoal goal, Date date, BigDecimal amount, String description) throws InsufficientBalanceException {
        CheckingAccountRepository checkingAccountRepository = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount checkingAccount = checkingAccountRepository.theAccount();

        try {
            SavingDeposit savingDeposit = new SavingDeposit(description, date, amount);

            SavingPlanRepository savingPlanRepository = PersistenceFactory.buildPersistenceFactory().savingPlanRepository();
            SavingPlan savingPlan = savingPlanRepository.theSavingPlan();

            // TODO should we call two different register methods or shuld the 
            // operation be encapsulated inside the "main" object?
            // where do we draw the line in our aggregates?
            checkingAccount.registerSavingDeposit(savingDeposit);
            savingPlan.registerSavingDeposit(savingDeposit, goal);

            savingPlanRepository.save(savingPlan);
            checkingAccountRepository.save(checkingAccount);
        } catch (InsufficientBalanceException ex) {
            throw ex;
        }
    }

    // TODO avoid duplication with RegisterSavingWithdrawController
    public List<SavingGoal> getSavingGoals() {
        // TODO should a controller create other controller objects?
        // to avoid duplication we migth encapsulate this method in another 
        // class which is not a controller
        return new ListSavingGoalsController().getSavingGoals();
    }
}
