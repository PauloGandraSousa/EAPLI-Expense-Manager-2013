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
public abstract class AlertEvent {

    private String alertDescription;
    private BigDecimal value;
    private String level;

    public AlertEvent(String alertDescription, BigDecimal value, String level) {
        this.alertDescription = alertDescription;
        this.level = level;
        this.value = value;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        double value1 = this.value.doubleValue();
        return "Alert Level :" + level + "\nDescription:" + alertDescription + "\nCurrent Value:" + formatter.
                format(value1);
    }
}
