/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.framework.Controller;
import eapli.framework.actions.Action;
import eapli.framework.actions.ReturnAction;
import eapli.framework.presentation.AbstractUI;
import eapli.framework.presentation.Menu;
import eapli.framework.presentation.MenuItem;
import eapli.framework.presentation.MenuSeparator;
import eapli.framework.presentation.ShowUiAction;
import eapli.framework.presentation.SubMenu;

/**
 * 
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

	private static final int EXIT_OPTION = 0;
	// expenses & incomes
	private static final int REGISTER_EXPENSE_OPTION = 1;
	private static final int REGISTER_INCOME_OPTION = 3;
	// saving plan
	private static final int REGISTER_SAVING_GOAL_OPTION = 5;
	// savings
	private static final int REGISTER_SAVING_DEPOSIT_OPTION = 7;
	private static final int REGISTER_SAVING_WITHDRAW_OPTION = 8;
	// configuration
	private static final int SET_ALERT_LIMITS_OPTION = 60;
	private static final byte REGISTER_INITIAL_BALANCE_OPTION = 70;
	// import & export
	private static final int EXPORT_MOVEMENTS = 80;
	// listings
	private static final int LISTINGS_OPTION = 100;
	private static final int LIST_EXPENSES_OPTION = 2;
	private static final int LIST_INCOMES_OPTION = 4;
	private static final int LIST_EXPENSES_PER_TYPE_OPTION = 6;
	private static final int LIST_EXPENSES_PER_TYPE_TEXT_CHART_OPTION = 7;
	private static final int LIST_EXPENSES_PER_TYPE_GUI_CHART_OPTION = 8;
	// master tables
	private static final int MASTER_TABLES_OPTION = 200;
	private static final int REGISTER_EXPENSE_TYPE_OPTION = 20;
	private static final int LIST_EXPENSE_TYPES_OPTION = 21;
	private static final int REGISTER_INCOME_TYPE_OPTION = 30;
	private static final int LIST_INCOME_TYPES_OPTION = 31;
	private static final int REGISTER_PAYMENT_METHOD_OPTION = 40;
	private static final int LIST_PAYMENT_METHODS_OPTION = 41;

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
		// return showMenuOldStyle();
		return showMenuUsingCompositeAndCommand();
	}

	@Override
	public String headline() {
		return "EXPENSE MANAGER";
	}

	private boolean showMenuUsingCompositeAndCommand() {
		Menu menu = buildMainMenu();
		return menu.show();
	}

	private Menu buildListingsMenu() {
		Menu menu = new Menu("Listings...");

		// use a generic "show UI" action
		menu.addMenuItem(new MenuItem(LIST_EXPENSES_OPTION, "List expenses",
				new ShowUiAction(new ListExpensesUI())));
		menu.addMenuItem(new MenuItem(LIST_INCOMES_OPTION, "List incomes",
				new ShowUiAction(new ListIncomesUI())));
		menu.addMenuItem(new MenuItem(LIST_EXPENSES_PER_TYPE_OPTION,
				"List expenses per type", new ShowUiAction(
						new ListExpensesPerTypeUI())));
		menu.addMenuItem(new MenuItem(LIST_EXPENSES_PER_TYPE_TEXT_CHART_OPTION,
				"List expenses per type in text chart", new ShowUiAction(
						new ListExpensesPerTypeConsoleChartUI())));
		menu.addMenuItem(new MenuItem(LIST_EXPENSES_PER_TYPE_GUI_CHART_OPTION,
				"List expenses per type in GUI chart", new ShowUiAction(
						new ListExpensesPerTypeGraphicalChartUI())));

		menu.addMenuItem(new MenuItem(EXIT_OPTION, "Return", new ReturnAction()));

		return menu;
	}

	private Menu buildMasterTablesMenu() {
		Menu menu = new Menu("Master tables...");

		menu.addMenuItem(new MenuItem(REGISTER_EXPENSE_TYPE_OPTION,
				"Register an expense type", new ShowUiAction(
						new RegisterExpenseTypeUI())));

		menu.addMenuItem(new MenuItem(LIST_EXPENSE_TYPES_OPTION,
				"List expense types",
				new ShowUiAction(new ListExpenseTypesUI())));

		menu.addMenuItem(new MenuItem(REGISTER_INCOME_TYPE_OPTION,
				"Register an income type", new ShowUiAction(
						new RegisterIncomeTypeUI())));

		menu.addMenuItem(new MenuItem(LIST_INCOME_TYPES_OPTION,
				"List income types", new ShowUiAction(new ListIncomeTypesUI())));

		menu.addMenuItem(new MenuItem(REGISTER_PAYMENT_METHOD_OPTION,
				"Register a payment mean", new ShowUiAction(
						new RegisterPaymentMeanUI())));

		menu.addMenuItem(new MenuItem(LIST_PAYMENT_METHODS_OPTION,
				"List payment methods", new ShowUiAction(
						new ListPaymentMeansUI())));

		// TODO should we have the same option in more than one menu?
		menu.addMenuItem(new MenuItem(REGISTER_INITIAL_BALANCE_OPTION,
				"Register Initial Balance", new ShowUiAction(
						new RegisterInitialBalanceUI())));

		menu.addMenuItem(new MenuItem(EXIT_OPTION, "Return ",
				new ReturnAction()));

		return menu;
	}

	private Menu buildMainMenu() {
		Menu menu = new Menu();

		// add a menu item and create an "anonynous class" action
		menu.addMenuItem(new MenuItem(REGISTER_EXPENSE_OPTION,
				"Register an expense", new Action() {
					@Override
					public boolean execute() {
						RegisterExpenseUI registerExpenseUI = new RegisterExpenseUI();
						registerExpenseUI.show();
						return false;
					}
				}));
		// use a generic "show UI" action
		menu.addMenuItem(new MenuItem(REGISTER_INCOME_OPTION,
				"Register an income", new ShowUiAction(new RegisterIncomeUI())));

		menu.addMenuItem(new MenuSeparator());

		menu.addMenuItem(new MenuItem(REGISTER_SAVING_GOAL_OPTION,
				"Register Saving Goal", new ShowUiAction(
						new RegisterSavingGoalUI())));

		menu.addMenuItem(new MenuSeparator());

		menu.addMenuItem(new MenuItem(REGISTER_SAVING_DEPOSIT_OPTION,
				"Register Saving Deposit", new ShowUiAction(
						new RegisterSavingDepositUI())));

		menu.addMenuItem(new MenuItem(REGISTER_SAVING_WITHDRAW_OPTION,
				"Register Saving Withdraw", new ShowUiAction(
						new RegisterSavingWithdrawUI())));

		menu.addMenuItem(new MenuSeparator());

		menu.addMenuItem(new MenuItem(SET_ALERT_LIMITS_OPTION,
				"Set/change alert limits", new ShowUiAction(
						new ConfigureAlertLimitsUI())));

		menu.addMenuItem(new MenuItem(REGISTER_INITIAL_BALANCE_OPTION,
				"Register Initial Balance", new ShowUiAction(
						new RegisterInitialBalanceUI())));

		menu.addMenuItem(new MenuItem(EXPORT_MOVEMENTS,
				"Export Movements (CSV/XML/JSON)", new ShowUiAction(
						new ExportMovementsUI())));

		menu.addMenuItem(new MenuSeparator());

		menu.addMenuItem(new SubMenu(LISTINGS_OPTION, buildListingsMenu()));

		menu.addMenuItem(new SubMenu(MASTER_TABLES_OPTION,
				buildMasterTablesMenu()));

		menu.addMenuItem(new MenuItem(EXIT_OPTION, "Exit",
				new ExitWithMessageAction()));

		return menu;
	}

	@Override
	protected Controller getController() {
		throw new UnsupportedOperationException("Should NEVER happen.");
	}
}
