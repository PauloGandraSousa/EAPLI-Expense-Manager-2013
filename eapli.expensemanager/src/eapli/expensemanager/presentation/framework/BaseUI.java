/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.framework;

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
    
    /**
     * derived classes should provide the controller object
     * 
     * an example of the Factory Method and Template Method patterns
     * 
     * @return 
     */
    protected abstract BaseController controller();
    
    /**
     * derived classes should override this method to perform the actual rendering
     * of the UI
     * 
     * follows the Template Method pattern
     * 
     * @return 
     */
    protected abstract boolean doShow();
    
    /**
     * derived classes should override this method to provide the title of the 
     * "window"
     * 
     * @return 
     */
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
        drawFormBorder();
        //Console.waitForKey("Press any key.");
        
        return wantsToExit;
    }
    
    protected void showBalances() {
        drawFormSeparator();
        System.out.print("| expenditure - this week: ");
        System.out.print(NumberFormat.getCurrencyInstance().format( controller().getThisWeekExpenditure()));
        System.out.print(" - ");
        System.out.print("this month: ");
        System.out.print(NumberFormat.getCurrencyInstance().format( controller().getThisMonthExpenditure()));
        System.out.println(" | ");
    }

    protected void drawFormTitle() {
        System.out.println();
        drawFormTitle(headline());
        System.out.println();
    }

    protected void drawFormBorder() {
        System.out.println(BORDER);
        System.out.println();
    }

    protected void drawFormSeparator() {
        System.out.println(SEPARATOR);
    }

    protected void drawFormTitle(String title) {
        String titleBorder = BORDER.substring(0, 2) + " " + title + " " + BORDER.substring(4+title.length());
        System.out.println(titleBorder);
    }
}
