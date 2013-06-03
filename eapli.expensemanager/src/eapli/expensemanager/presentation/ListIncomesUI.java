/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.visitors.IncomeListVisitor;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListIncomesController;
import eapli.expensemanager.model.Income;
import eapli.framework.presentation.ListWidget;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListIncomesUI extends BaseUI {

    private ListIncomesController controller = new ListIncomesController();
    private ListWidget<Income> widget;

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    protected boolean doShow() {
        widget = new ListWidget<Income>(controller.getIncomes(), new IncomeListVisitor());
        widget.show();

        return true;
    }

    @Override
    public String headline() {
        return "LIST INCOMES";
    }
}
