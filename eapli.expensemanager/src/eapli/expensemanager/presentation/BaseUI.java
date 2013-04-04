/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.util.Console;
import java.text.NumberFormat;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class BaseUI {
    public static final String SEPARATOR = "+---------------------------------------------------------------------------------+";
    public static final String    BORDER = "+=================================================================================+";
    
    // derived classes should provide the controller object
    protected abstract BaseController controller();
    
    protected abstract boolean doShow();
    public abstract String headline();
    
    public void mainLoop() {
        boolean wantsToExit;
        do {
            wantsToExit = show();
        } while (!wantsToExit);
    }

    public boolean show() {
        drawFormTitle();
        boolean wantsToExit = doShow();
        showBalances();
        Console.waitForKey("Press any key.");
        
        return wantsToExit;
    }
    
    public void showBalances() {
        drawFormSeparator();
        System.out.print("| this week expenditure: ");
        System.out.print(NumberFormat.getCurrencyInstance().format( controller().getThisWeekExpenditure()));
        System.out.print(" | ");
        System.out.print("this month expenditure: ");
        System.out.println(NumberFormat.getCurrencyInstance().format( controller().getThisMonthExpenditure()));
        drawFormBorder();
    }

    protected void drawFormTitle() {
        drawFormTitle(headline());
        System.out.println();
    }

    protected void drawFormBorder() {
        System.out.println(BORDER);
    }

    protected void drawFormSeparator() {
        System.out.println(SEPARATOR);
    }

    private void drawFormTitle(String title) {
        String titleBorder = BORDER.substring(0, 2) + " " + title + " " + BORDER.substring(4+title.length());
        System.out.println(titleBorder);
    }
}
