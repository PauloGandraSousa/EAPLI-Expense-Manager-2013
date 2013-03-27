/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.ExpenseType;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface ExpenseTypeRepository {

    ExpenseType findOrCreate(String key, String description);

    void save(ExpenseType expenseType);

    public List<ExpenseType> all();
    
}
