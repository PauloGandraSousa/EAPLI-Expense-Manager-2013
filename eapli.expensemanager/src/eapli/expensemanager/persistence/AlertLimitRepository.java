/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.observer.AlertLimit;
import eapli.expensemanager.model.observer.AlertLimitByExpenseType;
import eapli.expensemanager.model.observer.AlertLimitExpenditure;
import eapli.expensemanager.model.observer.AlertLimitType;
import java.util.List;

/**
 *
 * @author mcn
 */
public interface AlertLimitRepository {

    List<AlertLimit> all();

    AlertLimit save(AlertLimit alertLimit);

    // TODO does it make sense for this API to have save() and update()
    void save(AlertLimitByExpenseType alertLimit);

    void save(AlertLimitExpenditure alertLimit);

    AlertLimitExpenditure update(AlertLimitExpenditure a);

    AlertLimitByExpenseType update(AlertLimitByExpenseType a);

    AlertLimit findByKey(int i);

    List<AlertLimitExpenditure> findByAlertType(AlertLimitType a);

    // TODO refactor to a more meaningfull name
    List<AlertLimitByExpenseType> findByET(ExpenseType eT);
}
