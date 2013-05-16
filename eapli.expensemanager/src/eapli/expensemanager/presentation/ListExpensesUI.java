/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListExpensesController;
import eapli.expensemanager.model.Expense;
import eapli.framework.presentation.ListWidget;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListExpensesUI extends BaseUI {

    private ListExpensesController controller = new ListExpensesController();

    @Override
    protected BaseController getController() {
        return controller;
    }
    ListWidget<Expense> widget;

    @Override
    public boolean doShow() {
        widget = new ListWidget<Expense>(controller.getExpenses(), new ExpenseListVisitor());
        widget.show();

        return true;
    }

    @Override
    public String headline() {
        return "LIST EXPENSES";
    }
}
