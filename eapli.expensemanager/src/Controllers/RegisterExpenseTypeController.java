/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.ExpenseType;
import Persistence.ExpenseTypeRepository;
import Persistence.PersistenceRegistry;

/**
 *
 * @author arocha
 */
public class RegisterExpenseTypeController {

    public RegisterExpenseTypeController() {
    }

    public void registerExpenseType(String shortName, String Descr) {
        ExpenseType expenseType = new ExpenseType(shortName, Descr);
        ExpenseTypeRepository repo = PersistenceRegistry.instance().expenseTypeRepository();
        repo.save(expenseType);
    }
}
