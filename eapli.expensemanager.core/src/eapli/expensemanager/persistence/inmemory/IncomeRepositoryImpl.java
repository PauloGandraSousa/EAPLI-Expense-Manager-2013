/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.IncomeRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class IncomeRepositoryImpl extends InMemoryRepositoryBase<Income, Long> implements IncomeRepository {

    static List<Income> incomes = new ArrayList<Income>();

    @Override
    protected List<Income> getStaticStore() {
        return Collections.unmodifiableList(incomes);
    }

    @Override
    protected boolean matches(Income entity, Long id) {
        return entity.is(id);
    }
}
