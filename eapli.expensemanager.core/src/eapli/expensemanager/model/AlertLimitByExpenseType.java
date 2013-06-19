/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author mcn
 */
@Entity
public class AlertLimitByExpenseType extends AlertLimit {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final int ONE_HUNDRED = 100;
    private double percentLimitYellow;
    private double percentLimitRed;
    @OneToOne
    private ExpenseType expenseType;

    public AlertLimitByExpenseType() {
    }

    public AlertLimitByExpenseType(AlertLimitType alertType,
                                   double percentLimitYellow,
                                   double percentLimitRed, ExpenseType eT) {
        super(alertType);
        this.percentLimitYellow = percentLimitYellow;
        this.percentLimitRed = percentLimitRed;
        this.expenseType = eT;
    }

    public double getPercentLimitYellow() {
        return percentLimitYellow;
    }

    public double getPercentLimitRed() {
        return percentLimitRed;
    }

    public void setPercentLimitYellow(double percentLimitYellow) {
        this.percentLimitYellow = percentLimitYellow;
    }

    public void setPercentLimitRed(double percentLimitRed) {
        this.percentLimitRed = percentLimitRed;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    @Override
    public String toString() {
        String str = super.toString() + "\nYellow Limit- Average deviation:"
                + percentLimitYellow * ONE_HUNDRED + "%"
                + "\nRed Limit: Average deviation:" + percentLimitRed * 100
                + "%\nExpenseType:" + expenseType.getDescription();
        return str;
    }

    public void updateLimits(double yellow, double red) {
        this.percentLimitYellow = yellow;
        this.percentLimitRed = red;
    }
}
