/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mcn
 */
public class ExpenseRegisteredEvent {
            private Expense expenseRegistered;

      public ExpenseRegisteredEvent(Expense expenseRegistered) {
            this.expenseRegistered = expenseRegistered;
      }
      
      
     public int getYearOcurred(){
           Date date=expenseRegistered.getDateOcurred();
           return DateTime.dateToCalendar(date).get(Calendar.YEAR);
     }
     public int getMonthOccurred(){
           Date date=expenseRegistered.getDateOcurred();
           return DateTime.dateToCalendar(date).get(Calendar.MONTH) + 1;    
     }
     
     public int getWeekOccurred(){
           Date date=expenseRegistered.getDateOcurred();
           int week=DateTime.weekNumber(date);
           return week;  
     }
      public BigDecimal getAmount(){
           return expenseRegistered.getAmount();
            
      }
      
      public ExpenseType getExpenseType(){
            return expenseRegistered.getExpenseType();
      }

      public Expense getExpenseRegistered() {
            return expenseRegistered;
      }
}
