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
public class AlertEventExpenditure extends AlertEvent {

    private BigDecimal yellow;
    private BigDecimal red;

    public AlertEventExpenditure(String alertTypeDescription, BigDecimal yellow, BigDecimal red, BigDecimal value, String level) {
        super(alertTypeDescription, value, level);
        this.yellow = yellow;
        this.red = red;
    }

    @Override
    public String toString() {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        double yellow1 = this.yellow.doubleValue();
        double red1 = this.red.doubleValue();

        return super.toString() + "\nLimit Yellow:" + n.format(yellow1) + "      Limit Red:" + n.format(red1);
    }
}
