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
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mcn
 */
public interface AlertLimitRepository {

      List<AlertLimit> all();

      void save(AlertLimitExpenditure alertLimit);

      void save(AlertLimitByExpenseType alertLimit);

      AlertLimitExpenditure update(int key, BigDecimal yellow, BigDecimal red);

      AlertLimitByExpenseType update(int key, double yellow, double red);

      AlertLimit findByKey(int i);

      List<AlertLimitExpenditure> findByAlertType(AlertLimitType a);

      List<AlertLimitByExpenseType> findByET(ExpenseType eT);
}
