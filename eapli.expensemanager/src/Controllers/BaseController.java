/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.ExpenseRecord;
import Persistence.ExpenseRepository;
import Persistence.PersistenceRegistry;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class BaseController {
    /**
     * gets the expenditure of the current week
     * this method asks the repository to recreate the expense record of the desired week
     * and performs the calculation in memory
     * 
     * @return 
     */
    public BigDecimal getThisWeekBalance() {
        ExpenseRepository repo = PersistenceRegistry.instance().expenseRepository();
        int year = DateTime.currentYear();
        int week = DateTime.currentWeekNumber();
        Date start = DateTime.firstDateOfWeek(year, week).getTime();
        Date end = DateTime.lastDateOfWeek(year, week).getTime();

        ExpenseRecord expenseRecord = new ExpenseRecord(repo.between(start, end));
        return expenseRecord.getExpenditure();
    }
    
    /**
     * gets the expenditure of the current month
     * this methods relies on the repository to do the calculation
     * @return 
     */
    public BigDecimal getThisMonthBalance() {
        ExpenseRepository repo = PersistenceRegistry.instance().expenseRepository();
        return repo.expenditureOfMonth(DateTime.currentYear(), DateTime.currentMonth());        
    }
}
