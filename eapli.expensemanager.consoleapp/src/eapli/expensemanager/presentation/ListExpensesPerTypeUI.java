/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.ListExpensesPerTypeController;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Movement;
import eapli.expensemanager.model.report.AggregatedExpenses;
import eapli.expensemanager.model.report.ExpensesReport;
import eapli.util.DateTime;
import java.util.List;
import java.util.Map.Entry;

/**
 * Para se criar o UI para os agregadores de despesa, existe a possibilidade de
 * se especializar a classe ListExpensesUI, que é semelhante ou criar-se uma
 * nova. 1) Para se manter independência entre os casos de uso, não se deve
 * especializar a classe ListExpensesUI. 2) Se não houver problemas em haver
 * dependências, então pode-se especializar a classe ListExpensesUI
 *
 * @author Nuno Bettencourt
 */
class ListExpensesPerTypeUI extends BaseUI {

	private final ListExpensesPerTypeController controller = new ListExpensesPerTypeController();

	@Override
	protected ListExpensesPerTypeController getController() {
		return controller;
	}

	private void showExpenses(List<Expense> expenseList) {
		int position = 1;
		for (Movement expense : expenseList) {
			System.out.print("\t");
			System.out.print(position + ". ");
			System.out.print(DateTime.format(expense.getOccurred()) + " ");
			System.out.print(expense.getAmount() + " ");
			System.out.println(expense.getDescription());
			position++;
		}
	}

	/**
	 * Lists all expense movements grouped by their type it does not display
	 * types with no movements
	 *
	 * @return
	 */
	//TODO: NMB:pretende-se mostrar também tipos que não tenham movimentos?
	@Override
	public boolean doShow() {
		ExpensesReport expenseReport = controller.
				getExpensesClassifiedByExpenseType();
        //Map<ExpenseType, List<Expense>> mapExpenses = controller.getExpensesClassifiedByExpenseType();

		for (Entry<ExpenseType, AggregatedExpenses> entry : expenseReport.
				getAggregatedExpensesPerType().entrySet()) {
			System.out.print(entry.getKey().getDescription());
			System.out.println("\tTotal amount:" + entry.getValue().getSum());
			showExpenses(entry.getValue().all());
		}

		return true;
	}

	@Override
	public String headline() {
		return "LIST EXPENSES PER TYPE";
	}
}
