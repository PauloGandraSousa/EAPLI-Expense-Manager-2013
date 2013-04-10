/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import eapli.expensemanager.persistence.PersistenceRegistry;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class RegisterIncomeTypeController extends BaseController {

    public RegisterIncomeTypeController() {
    }

    public void registerIncomeType(String shortName, String Descr) {
        IncomeType incomeType = new IncomeType(shortName, Descr);
        IncomeTypeRepository repo = PersistenceRegistry.instance().incomeTypeRepository();
        repo.save(incomeType);
    }

}
