/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.visitors.SavingGoalListVisitor;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterSavingDepositController;
import eapli.expensemanager.model.exceptions.InsufficientBalanceException;
import eapli.expensemanager.model.SavingGoal;
import eapli.framework.presentation.SelectWidget;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AJS
 */
public class RegisterSavingDepositUI extends RegisterMovementBaseUI {

    private SelectWidget<SavingGoal> widget;

    @Override
    public String headline() {
        return "REGISTER AN SAVING DEPOSIT";
    }

    @Override
    public boolean doShow() {
        // FIX this code is duplicated with RegisterSavingWithdrawUI
        SavingGoal savingGoal = readSavingGoal();
        if (savingGoal == null) {
            return true;
        }
        readGeneralData();
        try {
            controller.registerSavingDeposit(savingGoal, date, amount, what);
            System.out.println("\nSaving Deposit recorded!");
        } catch (InsufficientBalanceException ex) {
            Logger.getLogger(RegisterSavingDepositUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("unable to register a saving due to unsufficien balance");
        }
        return true;
    }
    private RegisterSavingDepositController controller = new RegisterSavingDepositController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    // FIX this code is duplicated with RegisterSavingWithdrawUI
    private SavingGoal readSavingGoal() {
        System.out.println("-- SAVING GOALS --");
        List<SavingGoal> listSavingGoal = controller.getSavingGoals();

        widget = new SelectWidget<SavingGoal>(listSavingGoal, new SavingGoalListVisitor());
        widget.show();
        int option = widget.selectedOption();
        if (option == 0) {
            return null;
        }

        SavingGoal savingGoal = listSavingGoal.get(option - 1);
        return savingGoal;
    }
}
