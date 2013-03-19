/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.BaseController;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class BaseUI {
    
    // derived classes should provide the controller object
    protected abstract BaseController controller();
    
    public void showBalances() {
        System.out.println("-------------------");
        System.out.print("weekly spenditure:");
        System.out.println(controller().getThisWeekBalance());
        System.out.print("monthly spenditure:");
        System.out.println(controller().getThisMonthBalance());
        System.out.println("-------------------\n");
    }
}
