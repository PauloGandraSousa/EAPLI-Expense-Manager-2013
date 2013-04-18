/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends BaseUI {

    // TODO restructure this class to use the Composite pattern and allow for 
    // flexible menu and submenu structure
    // use command pattenr for each action
    
    final byte EXIT_OPTION = 0;
    final byte REGISTER_EXPENSE_OPTION = 1;
    final byte LIST_EXPENSES_OPTION = 2;
    final byte REGISTER_INCOME_OPTION = 3;
    final byte LIST_INCOMES_OPTION = 4;
    final byte REGISTER_EXPENSE_TYPE_OPTION = 20;
    final byte LIST_EXPENSE_TYPES_OPTION = 21;
    final byte REGISTER_INCOME_TYPE_OPTION = 30;
    final byte LIST_INCOME_TYPES_OPTION = 31;
    final byte REGISTER_PAYMENT_METHOD_OPTION = 40;
    final byte LIST_PAYMENT_METHODS_OPTION = 41;

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }
    
    /**
     *
     * @return true if the user selected the exit option
     */
    public boolean doShow() {
        System.out.println(REGISTER_EXPENSE_OPTION + ". Register an expense");
        System.out.println(LIST_EXPENSES_OPTION + ". List expenses");
        System.out.println(REGISTER_INCOME_OPTION + ". Register an income");
        System.out.println(LIST_INCOMES_OPTION + ". List incomes");
        System.out.println("--- master tables ---");
        System.out.println(REGISTER_EXPENSE_TYPE_OPTION + ". Register an expense type");
        System.out.println(LIST_EXPENSE_TYPES_OPTION + ". List expense types");
        System.out.println(REGISTER_INCOME_TYPE_OPTION + ". Register an income type");
        System.out.println(LIST_INCOME_TYPES_OPTION + ". List income types");
        System.out.println(REGISTER_PAYMENT_METHOD_OPTION + ". Register a payment method");
        System.out.println(LIST_PAYMENT_METHODS_OPTION + ". List payment methods");
        System.out.println("--------------------");
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
            case LIST_INCOMES_OPTION:
                ListIncomesUI listIncomeUI = new ListIncomesUI();
                listIncomeUI.show();
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
            case REGISTER_PAYMENT_METHOD_OPTION:
                RegisterPaymentMethodUI registerPaymentMethodUI = new RegisterPaymentMethodUI();
                registerPaymentMethodUI.show();
                break;
            case LIST_PAYMENT_METHODS_OPTION:
                ListPaymentMethodsUI listPaymentMethodsUI = new ListPaymentMethodsUI();
                listPaymentMethodsUI.show();
                break;
            default:
                System.out.println("option not recognized.");
                break;
        }
        return option == 0;
    }

    static BaseController controller = new BaseController();
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public String headline() {
        return "EXPENSE MANAGER";
    }
}
