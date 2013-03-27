/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListExpenseTypesController;
import eapli.expensemanager.controllers.ListExpensesController;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListExpensesUI extends BaseUI {

    private ListExpensesController controller = new ListExpensesController();
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public void doShow() {
        int position = 1;
        List<Expense> listExpenses = controller.getExpenses();
        for (Expense et : listExpenses) {
            System.out.println(position + ". " + et.getDescription());
            position++;
        }
    }

    @Override
    public String headline() {
        return "* * *  LIST EXPENSES  * * *\n";    
    }
}
