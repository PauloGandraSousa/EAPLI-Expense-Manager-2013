/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.framework.presentation.*;
import java.text.NumberFormat;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class BaseForm extends BaseUI {
    
    protected BaseController baseController() {
        return (BaseController) controller();
    }
            
    @Override
    public boolean show() {
        drawFormTitle();
        boolean wantsToExit = doShow();
        showBalances();
        drawFormBorder();
        //Console.waitForKey("Press any key.");
        
        return wantsToExit;
    }
    
    protected void showBalances() {
        drawFormSeparator();
        System.out.print("| expenditure - this week: ");
        System.out.print(NumberFormat.getCurrencyInstance().format( baseController().getThisWeekExpenditure()));
        System.out.print(" - ");
        System.out.print("this month: ");
        System.out.print(NumberFormat.getCurrencyInstance().format( baseController().getThisMonthExpenditure()));
        System.out.println(" | ");
    }
}
