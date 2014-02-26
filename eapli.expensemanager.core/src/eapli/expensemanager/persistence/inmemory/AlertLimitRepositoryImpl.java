/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mcn
 */
public class AlertLimitRepositoryImpl extends InMemoryRepositoryBase<AlertLimit, Long> implements AlertLimitRepository {

    private static final List<AlertLimit> store = new ArrayList<AlertLimit>();

    @Override
    protected List<AlertLimit> getStaticStore() {
        return Collections.unmodifiableList(store);
    }

    @Override
    public AlertLimit findByAlertType(AlertLimitType a) {
        for (AlertLimit one : store) {
            if (one.getAlertType().equals(a)) {
                return one;
            }
        }
        return null;
    }

    @Override
    public AlertLimit findByExpenseType(ExpenseType eT) {
        for (AlertLimit one : store) {
            if (one instanceof AlertLimitByExpenseType) {
                AlertLimitByExpenseType aet = (AlertLimitByExpenseType) one;
                if (aet.getExpenseType().equals(eT)) {
                    return one;
                }
            }
        }
        return null;
    }

    @Override
    protected boolean matches(AlertLimit entity, Long id) {
        return entity.is(id);
    }
}
