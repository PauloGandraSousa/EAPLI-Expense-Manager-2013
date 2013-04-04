/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ListExpenseTypesController;
import eapli.expensemanager.model.ExpenseType;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ListExpenseTypesUI extends BaseUI {

    private ListExpenseTypesController controller = new ListExpenseTypesController();
    
    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    public boolean doShow() {
        // TODO remove duplicated code block also present in RegisterExpenseUI
        int position = 1;
        List<ExpenseType> listExpenseTypes = controller.getExpenseTypes();
        for (ExpenseType et : listExpenseTypes) {
            System.out.println(position + ". " + et.getDescription());
            position++;
        }
        return true;
    }

    @Override
    public String headline() {
        return "LIST EXPENSE TYPES";    
    }
}
