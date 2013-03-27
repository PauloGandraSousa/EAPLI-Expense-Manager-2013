/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;

/**
 *
 * @author arocha
 */
public class RegisterExpenseTypeController extends BaseController {

    public RegisterExpenseTypeController() {
    }

    public void registerExpenseType(String shortName, String Descr) {
        ExpenseType expenseType = new ExpenseType(shortName, Descr);
        ExpenseTypeRepository repo = PersistenceRegistry.instance().expenseTypeRepository();
        repo.save(expenseType);
    }
}
