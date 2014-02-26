/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListIncomeTypesController;
import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.presentation.visitors.IncomeTypeListVisitor;
import eapli.framework.presentation.ListWidget;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListIncomeTypesUI extends BaseUI {

    private final ListIncomeTypesController controller = new ListIncomeTypesController();
    private ListWidget<IncomeType> widget;

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public boolean doShow() {
        widget = new ListWidget<IncomeType>(controller.getIncomeTypes(), new IncomeTypeListVisitor());
        widget.show();

        return true;
    }

    @Override
    public String headline() {
        return "LIST INCOME TYPES";
    }
}
