/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu {

    final byte EXIT_OPTION = 0;
    final byte REGISTER_EXPENSE_OPTION = 1;
    final byte LIST_EXPENSES_OPTION = 2;
    final byte REGISTER_INCOME_OPTION = 3;
    final byte REGISTER_EXPENSE_TYPE_OPTION = 20;
    final byte LIST_EXPENSE_TYPES_OPTION = 21;
    final byte REGISTER_INCOME_TYPE_OPTION = 30;
    final byte LIST_INCOME_TYPES_OPTION = 31;

    /**
     *
     * @return true if the user selected the exit option
     */
    public boolean show() {
        System.out.println("===================");
        System.out.println("  EXPENSE MANAGER  ");
        System.out.println("===================\n");

        System.out.println(REGISTER_EXPENSE_OPTION + ". Register an expense");
        System.out.println(LIST_EXPENSES_OPTION + ". List expenses");
        System.out.println(REGISTER_INCOME_OPTION + ". Register an income");
        System.out.println("--- master tables ---");
        System.out.println(REGISTER_EXPENSE_TYPE_OPTION + ". Register an expense type");
        System.out.println(LIST_EXPENSE_TYPES_OPTION + ". List expense types");
        System.out.println(REGISTER_INCOME_TYPE_OPTION + ". Register an income type");
        System.out.println(LIST_INCOME_TYPES_OPTION + ". List income types");
        System.out.println("-------------------");
        System.out.println("0. Exit\n\n");

        int option = Console.readInteger("Please choose an option");
        switch (option) {
            case EXIT_OPTION:
                break;
            case REGISTER_EXPENSE_OPTION:
                RegisterExpenseUI registerExpenseUI = new RegisterExpenseUI();
                registerExpenseUI.show();
                break;
            case LIST_EXPENSES_OPTION:
                ListExpensesUI listExpensesUI = new ListExpensesUI();
                listExpensesUI.show();
                break;
            case REGISTER_EXPENSE_TYPE_OPTION:
                RegisterExpenseTypeUI registerExpenseTypeUI = new RegisterExpenseTypeUI();
                registerExpenseTypeUI.show();
                break;
            case REGISTER_INCOME_OPTION:
                RegisterIncomeUI registerIncomeUI = new RegisterIncomeUI();
                registerIncomeUI.show();
                break;
            case LIST_EXPENSE_TYPES_OPTION:
                ListExpenseTypesUI listExpensesTypesUI = new ListExpenseTypesUI();
                listExpensesTypesUI.show();
                break;
            case REGISTER_INCOME_TYPE_OPTION:
                RegisterIncomeTypeUI registerIncomeTypeUI = new RegisterIncomeTypeUI();
                registerIncomeTypeUI.show();
                break;
            case LIST_INCOME_TYPES_OPTION:
                ListIncomeTypesUI listIncomesTypesUI = new ListIncomeTypesUI();
                listIncomesTypesUI.show();
                break;
            default:
                System.out.println("option not recognized.");
                break;
        }
        return option == 0;
    }
}
