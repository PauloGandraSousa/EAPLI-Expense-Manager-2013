/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.observer;

import eapli.expensemanager.persistence.ActiveRecord;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 *
 * @author mcn
 */
@Entity
@Inheritance
public class AlertLimitExpenditure extends AlertLimit implements ActiveRecord {

      protected BigDecimal limitYellow;
      protected BigDecimal limitRed;

      public AlertLimitExpenditure() {
      }

      public AlertLimitExpenditure(AlertLimitType alertType, BigDecimal limitYellow, BigDecimal limitRed) {
            super(alertType);
            this.limitYellow = limitYellow;
            this.limitRed = limitRed;
      }

      public void setLimitYellow(BigDecimal limitYellow) {
            this.limitYellow = limitYellow;
      }

      public void setLimitRed(BigDecimal limitRed) {
            this.limitRed = limitRed;
      }

      @Override
      public String toString() {

            NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            double doubleLimitYellow = this.limitYellow.doubleValue();
            double doubleLimitRed = this.limitRed.doubleValue();
            String str = super.toString()
                    + "\nYellow Limit:" + n.format(doubleLimitYellow) + "\nRed Limit:" + n.format(doubleLimitRed);
            return str;
      }

      // FIX this method is to DB oriented. it migth make sense to have it as a business
      // method mut should have a more busines oriented name (e.g., updateLimits)
      // and NOT call any repository methods
      public void update(double limitYellow, double limitRed) {

            BigDecimal yellow = new BigDecimal(limitYellow);
            BigDecimal red = new BigDecimal(limitRed);
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.update(id, yellow, red);
      }

      public static AlertLimitExpenditure findByAlertType(AlertLimitType aLertType) {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            List<AlertLimitExpenditure> list = repo.findByAlertType(aLertType);
            if (list.isEmpty()) {
                  return null;
            }
            return list.get(0);
      }

      // TODO should be at the super class
      @Override
      public void save() {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.save(this);
      }
}
