/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitType;
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
      public AlertLimit save(AlertLimit alertLimit) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public AlertLimit findByAlertType(AlertLimitType a) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public AlertLimit findByExpenseType(ExpenseType eT) {
            throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public AlertLimit updateAL(AlertLimit al) {
            throw new UnsupportedOperationException("Not supported yet.");
      }
      
      }
