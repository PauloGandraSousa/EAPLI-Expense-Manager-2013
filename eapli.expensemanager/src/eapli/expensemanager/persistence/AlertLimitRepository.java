/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import java.util.List;

/**
 *
 * @author mcn
 */
public interface AlertLimitRepository {

    List<AlertLimit> all();

    AlertLimit save(AlertLimit alertLimit);

    AlertLimit findByKey(int i);

    AlertLimit findByAlertType(AlertLimitType a);

    AlertLimit findByExpenseType(ExpenseType eT);
    
    AlertLimit updateAL(AlertLimit al);
}
