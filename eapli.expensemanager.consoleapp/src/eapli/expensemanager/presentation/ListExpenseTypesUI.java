/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListExpenseTypesController;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.presentation.visitors.ExpenseTypeListVisitor;
import eapli.framework.presentation.ListWidget;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListExpenseTypesUI extends BaseUI {

    private final ListExpenseTypesController controller = new ListExpenseTypesController();
    private ListWidget<ExpenseType> widget;

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public boolean doShow() {
        widget = new ListWidget<ExpenseType>(controller.getExpenseTypes(), new ExpenseTypeListVisitor());
        widget.show();
        return true;
    }

    @Override
    public String headline() {
        return "LIST EXPENSE TYPES";
    }
}
