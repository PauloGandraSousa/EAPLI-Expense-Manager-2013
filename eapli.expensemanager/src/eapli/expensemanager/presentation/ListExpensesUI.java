/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.framework.presentation.BaseUI;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListExpensesController;
import eapli.expensemanager.model.Expense;
import eapli.framework.presentation.ListWidget;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListExpensesUI extends BaseForm {

    private ListExpensesController controller = new ListExpensesController();
    
    @Override
    protected BaseController controller() {
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
