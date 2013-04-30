/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.framework.ReturnAction;
import eapli.expensemanager.presentation.framework.BaseUI;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.presentation.framework.Action;
import eapli.expensemanager.presentation.framework.Menu;
import eapli.expensemanager.presentation.framework.MenuItem;
import eapli.expensemanager.presentation.framework.MenuSeparator;
import eapli.expensemanager.presentation.framework.NullAction;
import eapli.expensemanager.presentation.framework.ShowUiAction;
import eapli.expensemanager.presentation.framework.SubMenu;
import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends BaseUI {

    // TODO restructure this class to use the Composite pattern and allow for 
    // flexible menu and submenu structure
    // use command pattern for each action
    final int EXIT_OPTION = 0;
    final int REGISTER_EXPENSE_OPTION = 1;
    final int LIST_EXPENSES_OPTION = 2;
    final int REGISTER_INCOME_OPTION = 3;
    final int LIST_INCOMES_OPTION = 4;
    final int LIST_EXPENSES_PER_TYPE_OPTION = 6;
    final int LIST_EXPENSES_PER_TYPE_TEXT_CHART_OPTION = 7;
    final int LIST_EXPENSES_PER_TYPE_GUI_CHART_OPTION = 71;
    final int REGISTER_EXPENSE_TYPE_OPTION = 20;
    final int LIST_EXPENSE_TYPES_OPTION = 21;
    final int REGISTER_INCOME_TYPE_OPTION = 30;
    final int LIST_INCOME_TYPES_OPTION = 31;
    final int REGISTER_PAYMENT_METHOD_OPTION = 40;
    final int LIST_PAYMENT_METHODS_OPTION = 41;
    final int REGISTER_SAVING_GOAL_OPTION = 51;
    final int LISTINGS_OPTION = 100;
    final int MASTER_TABLES_OPTION = 200;

    public MainMenu() {
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     *
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        //return showMenuOldStyle();
        return showMenuUsingCompositeAndAction();
    }

    @Override
    protected BaseController controller() {
        return null;
    }

    @Override
    public String headline() {
        return "EXPENSE MANAGER";
    }

    private boolean showMenuUsingCompositeAndAction() {
        Menu menu = buildMainMenu();
        return menu.show();
    }

    private Menu buildListingsMenu() {
        Menu menu = new Menu("Listings");

        // use a generic "show UI" action
        menu.addMenuItem(
                new MenuItem(LIST_EXPENSES_OPTION, "List expenses",
                new ShowUiAction(new ListExpensesUI())));
        menu.addMenuItem(
                new MenuItem(LIST_INCOMES_OPTION, "List incomes",
                new ShowUiAction(new ListIncomesUI())));
        menu.addMenuItem(
                new MenuItem(LIST_EXPENSES_PER_TYPE_OPTION, "List expenses per type",
                new ShowUiAction(new ListExpensesUIPerTypeConsole())));
        menu.addMenuItem(
                new MenuItem(LIST_EXPENSES_PER_TYPE_TEXT_CHART_OPTION, "List expenses per type in text chart",
                new ShowUiAction(new ListExpensesUIPerTypeTextChart())));
        menu.addMenuItem(
                new MenuItem(LIST_EXPENSES_PER_TYPE_GUI_CHART_OPTION, "List expenses per type in GUI chart",
                new ShowUiAction(new ListExpensesUIPerTypeGUIChart())));

        menu.addMenuItem(
                new MenuItem(0, "Return", new ReturnAction()));

        return menu;
    }
    
    private Menu buildMasterTablesMenu() {
        Menu menu = new Menu("Master tables");
        
        menu.addMenuItem(
                new MenuItem(REGISTER_EXPENSE_TYPE_OPTION, "Register an expense type",
                new ShowUiAction(new RegisterExpenseTypeUI())));

        menu.addMenuItem(
                new MenuItem(LIST_EXPENSE_TYPES_OPTION, "List expense types",
                new ShowUiAction(new ListExpenseTypesUI())));

        menu.addMenuItem(
                new MenuItem(REGISTER_INCOME_TYPE_OPTION, "Register an income type",
                new ShowUiAction(new RegisterIncomeTypeUI())));

        menu.addMenuItem(
                new MenuItem(LIST_INCOME_TYPES_OPTION, "List income types",
                new ShowUiAction(new ListIncomeTypesUI())));

        menu.addMenuItem(
                new MenuItem(REGISTER_PAYMENT_METHOD_OPTION, "Register a payment mean",
                new ShowUiAction(new RegisterPaymentMeanUI())));

        menu.addMenuItem(
                new MenuItem(LIST_PAYMENT_METHODS_OPTION, "List payment methods",
                new ShowUiAction(new ListPaymentMeansUI())));

        menu.addMenuItem(
                new MenuItem(0, "Return", new ReturnAction()));

        return menu;
    }

    private Menu buildMainMenu() {
        Menu menu = new Menu();

        // add a menu item and create an "anonynous class" action 
        menu.addMenuItem(
                new MenuItem(REGISTER_EXPENSE_OPTION, "Register an expense",
                new Action() {
            @Override
            public boolean execute() {
                RegisterExpenseUI registerExpenseUI = new RegisterExpenseUI();
                registerExpenseUI.show();
                return false;
            }
        }));
        // use a generic "show UI" action
        menu.addMenuItem(
                new MenuItem(REGISTER_INCOME_OPTION, "Register an income",
                new ShowUiAction(new RegisterIncomeUI())));

        menu.addMenuItem(new MenuSeparator());

        menu.addMenuItem(
                new MenuItem(REGISTER_SAVING_GOAL_OPTION, "Register Saving Goal",
                new ShowUiAction(new RegisterGoalSavingUI())));

        menu.addMenuItem(new MenuSeparator());
        
        menu.addMenuItem(
                new SubMenu(LISTINGS_OPTION, buildListingsMenu()));

        menu.addMenuItem(
                new SubMenu(MASTER_TABLES_OPTION, buildMasterTablesMenu()));

        menu.addMenuItem(
                new MenuItem(0, "Exit", new ExitWithMessageAction()));

        return menu;
    }

    private boolean showMenuOldStyle() {
        System.out.println(REGISTER_EXPENSE_OPTION + ". Register an expense");
        System.out.println(LIST_EXPENSES_OPTION + ". List expenses");
        System.out.println(REGISTER_INCOME_OPTION + ". Register an income");
        System.out.println(LIST_INCOMES_OPTION + ". List incomes");
        System.out.println(LIST_EXPENSES_PER_TYPE_OPTION + ". List expenses per type");
        System.out.println(LIST_EXPENSES_PER_TYPE_TEXT_CHART_OPTION + ". List expenses per type in text chart");
        System.out.println(LIST_EXPENSES_PER_TYPE_GUI_CHART_OPTION + ". List expenses per type in GUI chart");
        System.out.println(REGISTER_SAVING_GOAL_OPTION + ". Register SavingGoal");
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
            case LIST_EXPENSES_PER_TYPE_OPTION:
                ListExpensesUIPerTypeConsole listExpensesUIPerTypeConsole = new ListExpensesUIPerTypeConsole();
                listExpensesUIPerTypeConsole.show();
                break;
            case LIST_EXPENSES_PER_TYPE_TEXT_CHART_OPTION:
                ListExpensesUIPerTypeTextChart listExpensesUIPerTypeChart = new ListExpensesUIPerTypeTextChart();
                listExpensesUIPerTypeChart.show();
                break;
            case LIST_EXPENSES_PER_TYPE_GUI_CHART_OPTION:
                ListExpensesUIPerTypeGUIChart listExpensesUIPerTypeGUIChart = new ListExpensesUIPerTypeGUIChart();
                listExpensesUIPerTypeGUIChart.show();
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
                RegisterPaymentMeanUI registerPaymentMethodUI = new RegisterPaymentMeanUI();
                registerPaymentMethodUI.show();
                break;
            case LIST_PAYMENT_METHODS_OPTION:
                ListPaymentMeansUI listPaymentMethodsUI = new ListPaymentMeansUI();
                listPaymentMethodsUI.show();
                break;
            case REGISTER_SAVING_GOAL_OPTION:
                RegisterGoalSavingUI registergoalsavingUI = new RegisterGoalSavingUI();
                registergoalsavingUI.show();
                break;
            default:
                System.out.println("option not recognized.");
                break;
        }
        return option == 0;
    }
}
