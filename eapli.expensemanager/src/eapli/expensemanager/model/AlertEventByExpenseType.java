/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;


import java.math.BigDecimal;

/**
 *
 * @author mcn
 */
public class AlertEventByExpenseType extends AlertEvent {
      private ExpenseType expenseType;
      
      public AlertEventByExpenseType(String alertTypeDescription, BigDecimal yellow, BigDecimal red, BigDecimal value, String level, ExpenseType eT) {
            super(alertTypeDescription, yellow, red, value, level);
            this.expenseType=eT;
      }
      @Override
      public String toString(){
            return "Expense Tpe:"+expenseType.getDescription()+"\n"+super.toString();
      }
      
}
