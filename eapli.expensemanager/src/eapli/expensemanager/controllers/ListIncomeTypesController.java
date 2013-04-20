/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListIncomeTypesController extends BaseController {

    public List<IncomeType> getIncomeTypes() {
        IncomeTypeRepository repo = PersistenceFactory.buildPersistenceFactory().incomeTypeRepository();
        return repo.all();
    }    
}
