/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterSavingGoalController;
import eapli.util.Console;
import java.math.BigDecimal;

/**
 *
 * @author losa
 */
public class RegisterSavingGoalUI extends BaseForm {

    RegisterSavingGoalController controller = new RegisterSavingGoalController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public boolean doShow() {
        String tagetDescription = Console.readLine("Description of new Target");
        double value = Console.readDouble("Target Ammount");
        BigDecimal targetAmount = new BigDecimal(value);
        
        controller.registerSavingGoal(tagetDescription, targetAmount);

        System.out.println("\nSaving Goal registered.");
        
        return true;
    }

    @Override
    public String headline() {
        return "REGISTER NEW TARGET SAVING";
    }
}
