/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.SavingGoal;
import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.model.SavingWithdraw;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingPlanRepository;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author AJS
 */
public class RegisterSavingWithdrawController extends BaseController {

    public RegisterSavingWithdrawController() {
    }

    public void registerSavingWithdraw(SavingGoal goal, Calendar date,
                                       BigDecimal amount, String description) {
        SavingPlanRepository savingPlanRepository = PersistenceFactory
                .buildPersistenceFactory().savingPlanRepository();
        SavingPlan savingPlan = savingPlanRepository.theSavingPlan();

        // falta testar se o saldo é suficiente para resgatar
        // if(savingPlan.)

        // FIX controllers shouldn't have business logic
        if (goal.enoughSavings(amount)) {

            CheckingAccountRepository checkingAccountRepository = PersistenceFactory.
                    buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount checkingAccount = checkingAccountRepository
                    .theAccount();

            SavingWithdraw savingWithdraw = new SavingWithdraw(description,
                                                               date, amount);

            // TODO should we call two different register methods or should the
            // operation be encapsulated inside the "main" object?
            // where do we draw the line in our aggregates?
            savingPlan.registerSavingWithdraw(savingWithdraw, goal);
            checkingAccount.registerSavingWithdraw(savingWithdraw);

            savingPlanRepository.save(savingPlan);
            checkingAccountRepository.save(checkingAccount);
        }
    }

    // TODO avoid duplication with RegisterSavingDepositController
    public List<SavingGoal> getSavingGoals() {
        // TODO should a controller create other controller objects?
        // to avoid duplication we migth encapsulate this method in another
        // class which is not a controller
        return new ListSavingGoalsController().getSavingGoals();
    }
}
