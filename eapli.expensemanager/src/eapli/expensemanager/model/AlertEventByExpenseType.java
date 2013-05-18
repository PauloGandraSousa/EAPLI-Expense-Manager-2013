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
public class AlertEventByExpenseType extends AlertEvent {

    private BigDecimal average;
    private double yellow;
    private double red;
    private ExpenseType expenseType;

    public AlertEventByExpenseType(String alertTypeDescription, double yellow, double red, BigDecimal value, BigDecimal average, String level, ExpenseType eT) {
        super(alertTypeDescription, value, level);
        this.yellow = yellow;
        this.red = red;
        this.expenseType = eT;
        this.average = average;
    }

    @Override
    public String toString() {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        double average1 = this.average.doubleValue();
        return "Expense Tpe:" + expenseType.getDescription() + "\n" + super.toString() + "\nAverage:" + n.format(average1)
                + " Limit Yellow Deviation:" + yellow * 100 + "% Limit Red Deviation:" + red * 100 + "% ";
    }
}
