/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.ExpenseType;
import Model.ExpenseTypes;

/**
 *
 * @author arocha
 */
public class ExpenseTypeRegisterController {

    public ExpenseTypeRegisterController() {
    }

    public void registerTypeExpense(String Descr) {
        ExpenseType expenseType = new ExpenseType(Descr);
        ExpenseTypes.instance().register(expenseType);
    }
}
