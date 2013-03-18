/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.BaseController;
import Persistence.ExpenseRepository;
import Persistence.PersistenceRegistry;
import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu {

    public void mainLoop() {
        System.out.println("===================");
        int option = -1;
        while (option != 0) {
            System.out.println("===================");
            System.out.println("  EXPENSE MANAGER  ");
            System.out.println("===================\n");

            showBalances();

            System.out.println("1. Register an expense");
            System.out.println("2. Register an expense type");
            System.out.println("0. Exit\n\n");

            option = Console.readInteger("Please choose an option");
            switch (option) {
                case 0:
                    System.out.println("bye bye ...");
                    return;
                case 1:
                    ExpenseRegisterUI ui = new ExpenseRegisterUI();
                    ui.mainLoop();
                    break;
                case 2:
                    ExpenseTypeRegisterUI expenseTypeRegisterUI = new ExpenseTypeRegisterUI();
                    expenseTypeRegisterUI.mainLoop();
                    break;
            }
        }
    }

    private void showBalances() {
        BaseController controller  = new BaseController();
        
        System.out.print("weekly spenditure:");
        System.out.println(controller.getThisWeekBalance());
        System.out.print("monthly spenditure:");
        System.out.println(controller.getThisMonthBalance());
        System.out.println("-------------------\n");
    }
}
