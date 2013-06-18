/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class IncomeTypeRepositoryImpl extends InMemoryRepositoryBase<IncomeType, String> implements IncomeTypeRepository {

    static List<IncomeType> incomeTypes = new ArrayList<IncomeType>();

    @Override
    protected List<IncomeType> getStaticStore() {
        return incomeTypes;
    }

    @Override
    protected boolean matches(IncomeType entity, String id) {
        return entity.is(id);
    }
}
