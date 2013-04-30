/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.framework.presentation.BaseUI;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterTargetSavingController;
import eapli.expensemanager.model.ExpenseType;
import eapli.util.Console;
import java.math.BigDecimal;

/**
 *
 * @author losa
 */
public class RegisterGoalSavingUI extends BaseForm {

    RegisterTargetSavingController controller = new RegisterTargetSavingController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public boolean doShow() {

        String desctarget = Console.readLine("Description of new Target");

        double value = Console.readDouble("Total Ammount");
        BigDecimal totaltargetammount = new BigDecimal(value);
        controller.registerTargetSaving(desctarget, totaltargetammount);

        System.out.println("\nSaving Goal registered.");
        
        return true;
    }

    @Override
    public String headline() {
        return "REGISTER NEW TARGET SAVING";
    }
}
