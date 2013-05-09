/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mcn
 */
public class WatchDogLimits extends Observable implements Observer {

      @Override
      public void update(Observable o, Object arg) {
            ExpenseRegisteredEvent expenseRegisteredEvent = (ExpenseRegisteredEvent) arg;
            buildAlertEventsAndNotifyObservers(expenseRegisteredEvent);
      }

      private void buildAlertEventsAndNotifyObservers(ExpenseRegisteredEvent expense) {
            AlertLimitRepository alertLimitRepo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            AlertLimitType[] types = AlertLimitType.values();
            for (AlertLimitType alertLimType : types) {
                  switch (alertLimType) {
                        case LIMITWEEKEXPENDITURE:
                        case LIMITMONTHEXPENDITURE:
                             AlertLimit alertLimit =AlertLimit.findByAlertType(alertLimType);
                              if (alertLimit!=null) {
                                    AlertEvent alert = buildAlertEvent(alertLimit, expense);
                                    notifyObservers(alert);
                              }
                              break;
                        case LIMITDEVIATIONBYEXPTYPE:
                              ExpenseType eT = expense.getExpenseType();
                              AlertLimit alertLimitET= alertLimitRepo.findAlertLimitsByExpenseType(eT);
                              if (alertLimitET!=null){
                                    AlertEventByExpenseType alertEventByET = buildAlertEventAverageDeviationByExpenseType(expense, alertLimitET);
                                    notifyObservers(alertEventByET);
                              }
                              break;
                        case LIMITMINIMUMBALANCE:
                              
                              
                              
                              break;
                  }
            }
      }

    private AlertEvent buildAlertEvent(AlertLimit alertLimit, ExpenseRegisteredEvent expense) {
            int year = expense.getYearOcurred();
            ExpenseRepository expensesRepo = PersistenceFactory.buildPersistenceFactory().expenseRepository();
            BigDecimal expenditure;
            if (alertLimit.getAlertType().getCode() == 1) {
                  int week = expense.getWeekOccurred();
                  expenditure = expensesRepo.expenditureOfWeek(year, week);
            } else {
                  int month = expense.getMonthOccurred();
                  expenditure = expensesRepo.expenditureOfMonth(year, month);
            }
            AlertEvent alert = null;
            
            if(alertLimit.getClass()==AlertLimitExpenditure.class){ 
            BigDecimal yellow = ((AlertLimitExpenditure)alertLimit).getLimitYellow();
            BigDecimal red = ((AlertLimitExpenditure)alertLimit).getLimitRed();
            BigDecimal amount = expense.getAmount();
            expenditure = expenditure.add(amount);
            
            int level1 = compare(expenditure, yellow, red);
            switch (level1) {
                  case 0:
                        break;
                  case 1:
                        this.setChanged();
                        alert = new AlertEvent(alertLimit.getAlertType().getDescription(), yellow, red, expenditure, "YELLOW");
                        break;
                  case 2:
                        this.setChanged();
                        alert = new AlertEvent(alertLimit.getAlertType().getDescription(), yellow, red, expenditure, "RED");
                        break;
            }
            
      }
            return alert;
    }

      private AlertEventByExpenseType buildAlertEventAverageDeviationByExpenseType(ExpenseRegisteredEvent expenseRegisteredEvent, AlertLimit alertLimitET) {
            ExpenseType eT = expenseRegisteredEvent.getExpenseType();

            CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount account = repo.theAccount();

//      Obter total despesas

            BigDecimal average = new BigDecimal(30);


            BigDecimal amount = expenseRegisteredEvent.getAmount();

//            total=total.add(amount);
//            BigDecimal average = total.divide(new BigDecimal(list.size()+1));
            double red = ((AlertLimitByExpenseType)alertLimitET).getPercentLimitRed();
            double yellow = ((AlertLimitByExpenseType)alertLimitET).getPercentLimitYellow();

            BigDecimal yellowLim = average.multiply(new BigDecimal(yellow));
            BigDecimal redLim = average.multiply(new BigDecimal(red));

            AlertEventByExpenseType alertEvent = buildAlertEventByExpenseType(alertLimitET, amount, yellowLim, redLim, eT);
            return alertEvent;
      }

      private AlertEventByExpenseType buildAlertEventByExpenseType(AlertLimit alertLimitType, BigDecimal amount, BigDecimal yellow, BigDecimal red, ExpenseType eT) {

            AlertEventByExpenseType alert = null;
            int level1 = compare(amount, yellow, red);
            switch (level1) {
                  case 0:
                        break;
                  case 1:
                        this.setChanged();
                        alert = new AlertEventByExpenseType(alertLimitType.getAlertType().getDescription(), yellow, red, amount, "YELLOW", eT);
                        break;
                  case 2:
                        this.setChanged();
                        alert = new AlertEventByExpenseType(alertLimitType.getAlertType().getDescription(), yellow, red, amount, "RED", eT);
                        break;
            }
            return alert;
      }

      private int compare(BigDecimal valor, BigDecimal yellow, BigDecimal red) {
            int i = 0;
            if (valor.compareTo(yellow) >= 0) {
                  if (valor.compareTo(red) >= 0) {
                        return 2;
                  } else {
                        return 1;
                  }
            }
            return 0;
      }
}
