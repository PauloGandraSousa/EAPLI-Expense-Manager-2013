/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mcn
 */
public class SomeDefaultAlertLimitBootstrap {

      private final BigDecimal LIMITWEEKYELLOW = new BigDecimal(100);
      private final BigDecimal LIMITWEEKRED = new BigDecimal(500);
      private final BigDecimal LIMITMONTHYELLOW = new BigDecimal(600);
      private final BigDecimal LIMITMONTHRED = new BigDecimal(2000);
      private final double LIMITDEVIATIONYELLOW = 0.1;
      private final double LIMITDEVIATIONRED = 0.5;
      private final BigDecimal LIMITBALANCEYELLOW = new BigDecimal(600);
      private final BigDecimal LIMITBALANCERED = new BigDecimal(2000);

      public SomeDefaultAlertLimitBootstrap() {
            AlertLimitType[] types = AlertLimitType.values();
            int size = types.length;
            if (size > 0) {
                  for (AlertLimitType alertLimitType : types) {
                        switch (alertLimitType) {
                              case LIMITWEEKEXPENDITURE:
                                    if (AlertLimitExpenditure.findByAlertType(alertLimitType)==null){
                                         AlertLimitExpenditure alertLimitWeekExpenditure = new AlertLimitExpenditure(alertLimitType, LIMITWEEKYELLOW, LIMITWEEKRED);
                                          alertLimitWeekExpenditure.save();
                                    }
                                    break;
                              case LIMITMONTHEXPENDITURE:
                                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
                                          AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(alertLimitType, LIMITMONTHYELLOW, LIMITMONTHRED);
                                          alertLimitMonthExpenditure.save();
                                    }
                                    break;

                              case LIMITDEVIATIONBYEXPTYPE:
                                    ExpenseTypeRepository repo = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
                                    List<ExpenseType> list = repo.all();
                                    AlertLimitByExpenseType alertLimitET;
                                    for (ExpenseType eT : list) {
                                          alertLimitET = new AlertLimitByExpenseType(alertLimitType, LIMITDEVIATIONYELLOW, LIMITDEVIATIONRED, eT);
                                          alertLimitET.save();
                                    }
                                    break;

                              case LIMITMINIMUMBALANCE:
                                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
                                          AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(alertLimitType, LIMITMONTHYELLOW, LIMITMONTHRED);
                                          alertLimitMonthExpenditure.save();

                                    }
                                    break;
                        }
                  }
            }
      }
}