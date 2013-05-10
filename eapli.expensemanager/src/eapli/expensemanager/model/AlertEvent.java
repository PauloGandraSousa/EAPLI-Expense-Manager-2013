/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author mcn
 */
public class AlertEvent {

      private String alertDescription;
      private BigDecimal value;
      private String level;


      public AlertEvent(String alertDescription,  BigDecimal value, String level) {
            this.alertDescription = alertDescription;
            this.level=level;
            this.value=value;
      }

      @Override
      public String toString() {
            NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            double value1 = this.value.doubleValue();
            return   "ALERT LEVEL:" + level +"\nDescription:" +alertDescription + "\nCurrent Value:" + n.format(value1);

      }
}
