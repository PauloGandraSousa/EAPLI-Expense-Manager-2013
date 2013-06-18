/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;
import eapli.framework.persistence.repositories.Repository;

/**
 *
 * @author mcn
 */
public interface AlertLimitRepository extends Repository<AlertLimit, Long> {

    AlertLimit findByAlertType(AlertLimitType a);

    AlertLimit findByExpenseType(ExpenseType eT);
}
