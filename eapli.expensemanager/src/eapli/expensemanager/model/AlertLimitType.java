/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

/**
 *
 * @author mcn
 */
public enum AlertLimitType {

    /**
     * Limit week expenditure
     */
    LIMIT_WEEK_EXPENDITURE(1, "Alert limit of weekly expenditure"),
    /**
     * Limit month expenditure
     */
    LIMIT_MONTH_EXPENDITURE(2, "Alert limit of monthly expenditure"),
    /**
     * Limit of deviation from average by expense type
     */
    LIMIT_DEVIATION_BY_EXPENSE_TYPE(3, "Alert limit of deviation from average expenditure by expense type"),
    /**
     * Limit of minimum balance
     */
    LIMIT_MINIMUM_BALANCE(4, "Alert limit of minimum balance");
    /**
     * instance attributes.
     */
    private final int code;
    private final String description;

    /**
     * New instance - Constructor must be private
     */
    private AlertLimitType(int code, String description) {
        this.description = description;
        this.code = code;
    }

    /**
     * Returns code.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Returns the description .
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return code + ":" + description;
    }
}
