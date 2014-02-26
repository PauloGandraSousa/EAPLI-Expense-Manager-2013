/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.limits;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author mcn
 */
public class ExpenditureOverLimitAlertEvent extends AlertEvent {

    private final BigDecimal yellow;
    private final BigDecimal red;

    public ExpenditureOverLimitAlertEvent(String alertTypeDescription,
                                          BigDecimal yellow, BigDecimal red,
                                          BigDecimal value, String level) {
        super(alertTypeDescription, value, level);
        this.yellow = yellow;
        this.red = red;
    }

    @Override
    public String toString() {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.getDefault());
        double yellow1 = this.yellow.doubleValue();
        double red1 = this.red.doubleValue();

        return super.toString() + "\nLimit Yellow:" + n.format(yellow1) + "      Limit Red:" + n.
                format(red1);
    }
}
