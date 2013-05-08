/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.observer.AlertLimit;
import eapli.expensemanager.model.observer.AlertLimitByExpenseType;
import eapli.expensemanager.model.observer.AlertLimitExpenditure;
import eapli.expensemanager.model.observer.AlertLimitPercentValues;
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

      // FIX repository interface should deal with objects not individual attributes
      AlertLimitExpenditure update(int key, BigDecimal yellow, BigDecimal red);

      // FIX repository interface should deal with objects not individual attributes
      AlertLimitPercentValues update(int key, double yellow, double red);

      AlertLimit findByKey(int i);

      List<AlertLimitExpenditure> findByAlertType(AlertLimitType a);

      // TODO refactor to a more meaningfull name
      List<AlertLimitByExpenseType> findByET(ExpenseType eT);
}
