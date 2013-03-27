/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.ExpenseType;
import Persistence.ExpenseTypeRepository;
import Persistence.PersistenceRegistry;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListExpenseTypesController extends BaseController {

    // TODO removed duplicated method also present in RegisterExpenseController
    public List<ExpenseType> getExpenseTypes() {
        ExpenseTypeRepository repo = PersistenceRegistry.instance().expenseTypeRepository();
        return repo.all();
    }    
}
