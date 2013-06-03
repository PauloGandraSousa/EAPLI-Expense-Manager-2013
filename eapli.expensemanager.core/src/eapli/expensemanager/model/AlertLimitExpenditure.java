/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.persistence.Entity;

/**
 *
 * @author mcn
 */
@Entity
public class AlertLimitExpenditure extends AlertLimit {

      /**
       *
       */
      private static final long serialVersionUID = 1L;
      private BigDecimal limitYellow;
      private BigDecimal limitRed;

      public AlertLimitExpenditure() {
      }

      public AlertLimitExpenditure(AlertLimitType alertType,
              BigDecimal limitYellow, BigDecimal limitRed) {
            super(alertType);
            this.limitYellow = limitYellow;
            this.limitRed = limitRed;
      }

      public BigDecimal getLimitYellow() {
            return limitYellow;
      }

      public BigDecimal getLimitRed() {
            return limitRed;
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
            String str = super.toString() + "\nYellow Limit:"
                    + n.format(doubleLimitYellow) + "\nRed Limit:"
                    + n.format(doubleLimitRed);
            return str;
      }

      public void updateLimits(double limitYellow, double limitRed) {
            BigDecimal yellow = new BigDecimal(limitYellow);
            BigDecimal red = new BigDecimal(limitRed);
            this.limitYellow = yellow;
            this.limitRed = red;
      }
}
