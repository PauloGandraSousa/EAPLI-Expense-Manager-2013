/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.BaseController;
import Controllers.ListExpenseTypesController;
import Model.ExpenseType;
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
    public void doShow() {
        // TODO remove duplicated code block also present in RegisterExpenseUI
        int position = 1;
        List<ExpenseType> listExpenseTypes = controller.getExpenseTypes();
        for (ExpenseType et : listExpenseTypes) {
            System.out.println(position + ". " + et.getDescription());
            position++;
        }
    }

    @Override
    public String headline() {
        return "* * *  LIST EXPENSE TYPES  * * *\n";    
    }
}
