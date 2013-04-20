/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.charts;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Movement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nuno
 */
public interface IChart {

    public void setWindowTitle(String windowTitle);

    public void setChartTitle(String chartTitle);

    public void setDataset(Map<ExpenseType, BigDecimal> mapExpenses) ;

    public void doShow();
}
