/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.observer.AlertLimit;
import eapli.expensemanager.model.observer.AlertLimitByExpenseType;
import eapli.expensemanager.model.observer.AlertLimitExpenditure;
import eapli.expensemanager.model.observer.AlertLimitType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import java.util.List;

/**
 *
 * @author mcn
 */
public class AlertLimitRepositoryImpl implements AlertLimitRepository{

      @Override
      public List<AlertLimit> all() {
            throw new UnsupportedOperationException("Not supported yet.");
      }


      @Override
      public AlertLimit findByKey(int i) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

    
      @Override
      public List<AlertLimitByExpenseType> findByET(ExpenseType eT) {
            throw new UnsupportedOperationException("Not supported yet.");
      }


      @Override
      public List<AlertLimitExpenditure> findByAlertType(AlertLimitType a) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public AlertLimitExpenditure update(AlertLimitExpenditure a) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public AlertLimitByExpenseType update(AlertLimitByExpenseType a) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public void save(AlertLimitByExpenseType alertLimit) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public void save(AlertLimitExpenditure alertLimit) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

 

      @Override
      public AlertLimit save(AlertLimit alertLimit) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

 
      
}
