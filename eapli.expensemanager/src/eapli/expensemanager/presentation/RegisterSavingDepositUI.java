/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterSavingDepositController;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.SavingGoal;
import eapli.framework.presentation.SelectWidget;
import java.util.List;

/**
 *
 * @author AJS
 */
public class RegisterSavingDepositUI extends RegisterMovementBaseUI
{
    SelectWidget widget;

    @Override
    public String headline()
    {
        return "REGISTER AN SAVING DEPOSIT";
    }

    @Override
    public boolean doShow()
    {
        SavingGoal savingGoal = readSavingGoal();
        readGeneralData();
        controller.registerSavingDeposit(savingGoal, date, amount, what);
        System.out.println("\nSaving Deposit recorded!");
        return true;
    }

    RegisterSavingDepositController controller = new RegisterSavingDepositController();

    @Override
    protected BaseController controller()
    {
        return controller;
    }

    private SavingGoal readSavingGoal()
    {
        System.out.println("-- SAVING GOAL --");
        List<SavingGoal> listSavingGoal = controller.getSavingGoals();

        widget = new SelectWidget(listSavingGoal, new SavingGoalVisitor());
        widget.show();
        int option = widget.selectedOption();

        SavingGoal savingGoal = listSavingGoal.get(option - 1);
        return savingGoal;
    }
}
