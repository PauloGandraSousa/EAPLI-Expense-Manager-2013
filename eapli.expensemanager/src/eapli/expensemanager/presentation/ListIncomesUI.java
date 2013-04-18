/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListIncomesController;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListIncomesUI extends BaseUI {

    ListIncomesController controller = new ListIncomesController();
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    protected boolean doShow() {
        // FIX avoid duplicate code with ListExpenseUI
        int position = 1;
        List<Income> listIncomes = controller.getIncomes();
        for (Income i : listIncomes) {
            System.out.print(position + ". ");
            System.out.print(i.getDateOcurred() + " ");
            System.out.print(i.getAmount() + " ");
            System.out.println(i.getDescription());
            position++;
        }
        
        return true;
    }

    @Override
    public String headline() {
        return "LIST INCOMES";
    }
    
}
