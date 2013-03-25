/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu {

    public void mainLoop() {
        int option = -1;
        while (option != 0) {
            System.out.println("===================");
            System.out.println("  EXPENSE MANAGER  ");
            System.out.println("===================\n");

            System.out.println("1. Register an expense");
            System.out.println("2. Register an expense type");
            System.out.println("0. Exit\n\n");

            option = Console.readInteger("Please choose an option");
            switch (option) {
                case 0:
                    System.out.println("bye bye ...");
                    return;
                case 1:
                    RegisterExpenseUI registerExpenseUI = new RegisterExpenseUI();
                    registerExpenseUI.mainLoop();
                    break;
                case 2:
                    RegisterExpenseTypeUI registerExpenseTypeUI = new RegisterExpenseTypeUI();
                    registerExpenseTypeUI.mainLoop();
                    break;
            }
        }
    }
}
