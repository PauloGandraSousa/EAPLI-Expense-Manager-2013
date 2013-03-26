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
            System.out.println("2. List expenses");
            System.out.println("3. Register an income");
            System.out.println("--- master tables ---");
            System.out.println("20. Register an expense type");
            System.out.println("21. List expense types");
            System.out.println("30. Register an income type");
            System.out.println("31. List income types");
            System.out.println("--- --- --- --- ---");
            System.out.println("0. Exit\n\n");

            option = Console.readInteger("Please choose an option");
            switch (option) {
                case 0:
                    System.out.println("bye bye ...");
                    return;
                case 1:
                    RegisterExpenseUI registerExpenseUI = new RegisterExpenseUI();
                    registerExpenseUI.show();
                    break;
                case 20:
                    RegisterExpenseTypeUI registerExpenseTypeUI = new RegisterExpenseTypeUI();
                    registerExpenseTypeUI.show();
                    break;
                case 21:
                    ListExpenseTypesUI listExpensesTypesUI = new ListExpenseTypesUI();
                    listExpensesTypesUI.show();
                default:
                    System.out.println("option not recognized.");
                    break;
            }
        }
    }
}
