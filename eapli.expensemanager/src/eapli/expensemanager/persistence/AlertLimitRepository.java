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

      void save(AlertLimitByExpenseType alertLimit);
      
      void save(AlertLimitExpenditure alertLimit);

      // FIX repository interface should deal with objects not individual attributes
//      AlertLimitExpenditure update(int key, BigDecimal yellow, BigDecimal red);
       AlertLimitExpenditure update(AlertLimitExpenditure a);

      // FIX repository interface should deal with objects not individual attributes
      //AlertLimitByExpenseType update(int key, double yellow, double red);
      AlertLimitByExpenseType update( AlertLimitByExpenseType a);
     

      AlertLimit findByKey(int i);

      List<AlertLimitExpenditure> findByAlertType(AlertLimitType a);

      // TODO refactor to a more meaningfull name
      List<AlertLimitByExpenseType> findByET(ExpenseType eT);
}
