/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;


import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;

/**
 *
 * @author mcn
 */
public class SomeDefaultAlertLimitBootstrap {
 private final BigDecimal LIMITWEEKYELLOW = new BigDecimal(100);
      private final BigDecimal LIMITWEEKRED = new BigDecimal(500);
      private final BigDecimal LIMITMONTHYELLOW = new BigDecimal(600);
      private final BigDecimal LIMITMONTHRED = new BigDecimal(2000);

      public SomeDefaultAlertLimitBootstrap() {
            AlertLimitType[] types = AlertLimitType.values();
            int size = types.length;
            if (size > 0) {
                  AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
                  for (AlertLimitType alertLimitType : types) {
                        switch (alertLimitType) {
                              case LIMITWEEKEXPENDITURE:
                                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {                                     
                                          repo.save(new AlertLimitExpenditure(alertLimitType, LIMITWEEKYELLOW, LIMITWEEKRED));
                                    }
                                    break;
                              case LIMITMONTHEXPENDITURE:
                                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
                                          repo.save(new AlertLimitExpenditure(alertLimitType, LIMITMONTHYELLOW, LIMITMONTHRED));
                                    }
                                    break;

                        }
                  }
            }
      }
}