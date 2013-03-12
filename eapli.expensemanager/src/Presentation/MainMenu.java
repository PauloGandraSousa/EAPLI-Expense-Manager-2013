/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Model.ExpenseRecord;
import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu {

    public void mainLoop() {
        do {
            System.out.println("===================");
            System.out.println("  EXPENSE MANAGER  ");
            System.out.println("===================\n");

            showBalances();

            System.out.println("1. Register an expense");
            System.out.println("0. Exit\n\n");

            int option = Console.readInteger("Please choose a option");
            switch (option) {
                case 0:
                    System.out.println("bye bye ...");
                    return;
                case 1:
                    ExpenseRegisterUI ui = new ExpenseRegisterUI();
                    ui.mainLoop();
                    break;
            }
        } while (true);
    }
    
        private void showBalances() {
        System.out.print("weekly spenditure:");
        System.out.println(ExpenseRecord.instance().getThisWeekBalance());
        System.out.print("monthly spenditure:");
        System.out.println(ExpenseRecord.instance().getThisMonthBalance());
        System.out.println("-------------------\n");
    }

}
