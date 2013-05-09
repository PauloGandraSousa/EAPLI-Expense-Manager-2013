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
      private BigDecimal yellow;
      private BigDecimal  red;
      private BigDecimal  value;
      private String level;

      public AlertEvent(String alertDescription, BigDecimal yellow, BigDecimal red, BigDecimal value, String level) {
            this.alertDescription = alertDescription;
            this.yellow = yellow;
            this.red = red;
            this.value = value;
            this.level=level;
      }

      @Override
      public String toString(){
      NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRANCE);
     double yellow1 = this.yellow.doubleValue();
     double red1 = this.red.doubleValue();
     double value1 = this.value.doubleValue();
//      return "Alert Type:"+alertType+"   Limit Yellow:"+yellow1+"   Limit Red:"+red1+
//              "\n Current Value:"+value1+ " ALERT "+level;
     return " ALERT:"+level+ "  "+alertDescription+"\nLimit Yellow:"+yellow1+"   Limit Red:"+red1+
              "\n Current Value:"+value1;
}
      
}
