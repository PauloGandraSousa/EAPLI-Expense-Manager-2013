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
public class ExpenseTypeRepositoryImpl extends InMemoryRepositoryBase<ExpenseType, String> implements ExpenseTypeRepository {

    static List<ExpenseType> expenseTypes = new ArrayList<ExpenseType>();

    @Override
    protected List<ExpenseType> getStaticStore() {
        return expenseTypes;
    }

    @Override
    protected boolean matches(ExpenseType entity, String id) {
        return entity.getId().equals(id);
    }
}
