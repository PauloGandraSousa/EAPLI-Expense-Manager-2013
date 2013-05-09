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
      
      AlertLimit save(AlertLimit  alertLimit);

    // TODO does it make sense for this API to have save() and update()
       AlertLimitExpenditure update(AlertLimitExpenditure a);

      AlertLimitByExpenseType update( AlertLimitByExpenseType a);
     
      AlertLimit findByKey(int i);

      List<AlertLimitExpenditure> findByAlertType(AlertLimitType a);

      List<AlertLimitByExpenseType> findAlertLimitsByExpenseType(ExpenseType eT);
}
