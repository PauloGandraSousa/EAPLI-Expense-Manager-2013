/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;

/**
 *
 * @author mcn
 */
@Entity
public class AlertLimitExpenditure extends AlertLimit  {

      protected BigDecimal limitYellow;
      protected BigDecimal limitRed;

      public AlertLimitExpenditure() {
      }

      public BigDecimal getLimitYellow() {
            return limitYellow;
      }

      public BigDecimal getLimitRed() {
            return limitRed;
      }

      public AlertLimitExpenditure(AlertLimitType alertType, BigDecimal limitYellow, BigDecimal limitRed){
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

      public void updateLimits(double limitYellow, double limitRed) {

            BigDecimal yellow = new BigDecimal(limitYellow);
            BigDecimal red = new BigDecimal(limitRed);
        this.limitYellow = yellow;
        this.limitRed = red;
        // FIX this method should NOT call any repository methods but rely on the 
        // client code to call the object's save() method
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.update(this);
      }

//            @Override
//      public void update() {
//            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
//            repo.update(this);
//      }
    
      public static AlertLimitExpenditure findByAlertType(AlertLimitType aLertType) {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            List<AlertLimitExpenditure> list = repo.findByAlertType(aLertType);
            if (list.isEmpty()) {
                  return null;
            }
            return list.get(0);
      }
}
