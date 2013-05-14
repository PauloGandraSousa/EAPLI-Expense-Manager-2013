/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterSavingWithdrawController;
import eapli.expensemanager.model.SavingGoal;
import eapli.framework.presentation.SelectWidget;
import java.util.List;

/**
 *
 * @author AJS
 */
public class RegisterSavingWithdrawUI extends RegisterMovementBaseUI {

    SelectWidget widget;

    @Override
    public String headline() {
        return "REGISTER AN SAVING WITHDRAW";
    }

    @Override
    public boolean doShow() {
        // FIX this code is duplicated with RegisterSavingDepositUI
        SavingGoal savingGoal = readSavingGoal();
        readGeneralData();

        controller.registerSavingWithdraw(savingGoal, date, amount, what);
        System.out.println("\nSaving Withdraw recorded!");
        return true;
    }
    
    RegisterSavingWithdrawController controller = new RegisterSavingWithdrawController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    // FIX this code is duplicated with RegisterSavingDepositUI
    private SavingGoal readSavingGoal() {
        System.out.println("-- SAVING GOAL --");
        List<SavingGoal> listSavingGoal = controller.getSavingGoals();

        widget = new SelectWidget(listSavingGoal, new SavingGoalVisitor());
        widget.show();
        int option = widget.selectedOption();

        SavingGoal savingGoal = listSavingGoal.get(option - 1);
        return savingGoal;
    }
}
