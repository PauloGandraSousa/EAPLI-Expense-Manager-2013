/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.charts;

import eapli.expensemanager.model.report.ExpensesReport;

/**
 * Interface for setting data and displaying reports in charts
 * @author nuno
 */
public interface Chart {

    /**
     * Allows to set the chart window title
     * @param windowTitle
     */
    public void setWindowTitle(String windowTitle);

    /**
     * Allows to set the chart title
     * @param chartTitle
     */
    public void setChartTitle(String chartTitle);

    /**
     * Allows to set the data to be displayes in the chart
     * @param expenseReport
     */
    public void setDataset(ExpensesReport expenseReport);

    /**
     * Shows the chart windows
     */
    public void doShow();
}
