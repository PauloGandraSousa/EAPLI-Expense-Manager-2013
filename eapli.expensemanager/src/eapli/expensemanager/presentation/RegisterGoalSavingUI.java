/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterTargetSavingController;
import eapli.expensemanager.model.ExpenseType;
import eapli.util.Console;
import java.math.BigDecimal;
import eapli.expensemanager.presentation.framework.*;                                                                                                                                                                                            

/**
 *
 * @author losa
 */
public class RegisterGoalSavingUI extends BaseUI {
    
    RegisterTargetSavingController controller = new  RegisterTargetSavingController();
     @Override
    protected BaseController controller() {
        return controller;
    }
    
    @Override
    public boolean doShow() {
        
        String desctarget = Console.readLine("Description of new Target");
        
        double value =  Console.readDouble("Total Ammount");
        BigDecimal totaltargetammount = new BigDecimal(value);
        controller.registerTargetSaving(desctarget,totaltargetammount);
        
        return true; 
    }

    @Override
    public String headline() {
        return "REGISTER NEW TARGET SAVING";    
    }
   public boolean show()
   {
       headline();
       doShow();
       return true;
   }
}
