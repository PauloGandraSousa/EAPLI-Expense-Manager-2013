/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeRepositoryImpl implements ExpenseTypeRepository {

    static List<ExpenseType> expenseTypes = new ArrayList<ExpenseType>();
    
    @Override
    public ExpenseType findForName(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExpenseType save(ExpenseType expenseType) {
        expenseTypes.add(expenseType);
        return expenseType;
    }

    @Override
    public List<ExpenseType> all() {
        return expenseTypes;
    }    
}
