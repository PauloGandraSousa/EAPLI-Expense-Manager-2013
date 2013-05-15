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
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
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
                        case LIMIT_WEEK_EXPENDITURE:
                        case LIMIT_MONTH_EXPENDITURE:
                              AlertLimitExpenditure alertLimit =(AlertLimitExpenditure) AlertLimit.findByAlertType(alertLimType);
                              if (alertLimit != null) {
                                    AlertEvent alert = buildAlertEvent(alertLimit, expense);
                                    notifyObservers(alert);
                              }
                              break;
                        case LIMIT_DEVIATION_BY_EXPENSE_TYPE:
                              ExpenseType eT = expense.getExpenseType();
                              AlertLimitByExpenseType alertLimitET =(AlertLimitByExpenseType) alertLimitRepo.findAlertLimitsByExpenseType(eT);
                              if (alertLimitET != null) {
                                    AlertEventByExpenseType alertEventByET = buildAlertEventAverageDeviationByExpenseType(expense, alertLimitET);
                                    notifyObservers(alertEventByET);
                              }
                              break;
                        case LIMIT_MINIMUM_BALANCE:
                              AlertLimitExpenditure alertLimitBalance = (AlertLimitExpenditure)AlertLimit.findByAlertType(alertLimType);
                              if (alertLimitBalance != null) {
                                    AlertEvent alert = buildAlertBalanceEvent(alertLimitBalance, expense);
                                    notifyObservers(alert);
                              }
                              break;
                  }
            }
      }

      private AlertEvent buildAlertEvent(AlertLimitExpenditure alertLimit, ExpenseRegisteredEvent expense) {
            int year = expense.getYearOcurred();
            //TODO: CheckingAccount should implement expenditureOfWeek and expenditureOfMonth
            // update this code
            ExpenseRepository expensesRepo = PersistenceFactory.buildPersistenceFactory().expenseRepository();
            BigDecimal expenditure;
            if (alertLimit.getAlertType().getCode() == 1) {
                  int week = expense.getWeekOccurred();
                  expenditure = expensesRepo.expenditureOfWeek(year, week);
            } else {
                  int month = expense.getMonthOccurred();
                  expenditure = expensesRepo.expenditureOfMonth(year, month);
            }
            AlertEventExpenditure alert = null;

            BigDecimal yellow =alertLimit.getLimitYellow();
            BigDecimal red = alertLimit.getLimitRed();
            BigDecimal amount = expense.getAmount();
            //Because the expense registered is not saved yet
            expenditure = expenditure.add(amount);
            int level1 = compare(expenditure, yellow, red);
            switch (level1) {
                  case 0:
                        break;
                  case 1:
                        this.setChanged();
                        alert = new AlertEventExpenditure(alertLimit.getAlertType().getDescription(), yellow, red, expenditure, "YELLOW");
                        break;
                  case 2:
                        this.setChanged();
                        alert = new AlertEventExpenditure(alertLimit.getAlertType().getDescription(), yellow, red, expenditure, "RED");
                        break;
            }
            return alert;
      }

      private AlertEvent buildAlertBalanceEvent(AlertLimitExpenditure alertLimit, ExpenseRegisteredEvent expense) {
            CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount account = repo.theAccount();
            BigDecimal balance = account.getBalance();
            //Because the expense registered is not saved yet
           // balance.subtract(expense.getAmount());
            AlertEventExpenditure alert = null;

            BigDecimal yellow = alertLimit.getLimitYellow();
            BigDecimal red = alertLimit.getLimitRed();

            int level1 = compareBalance(balance, yellow, red);
            switch (level1) {
                  case 0:
                        break;
                  case 1:
                        this.setChanged();
                        alert = new AlertEventExpenditure(alertLimit.getAlertType().getDescription(), yellow, red, balance, "YELLOW");
                        break;
                  case 2:
                        this.setChanged();
                        alert = new AlertEventExpenditure(alertLimit.getAlertType().getDescription(), yellow, red, balance, "RED");
                        break;
            }
            return alert;
      }

      private AlertEventByExpenseType buildAlertEventAverageDeviationByExpenseType(ExpenseRegisteredEvent expenseRegisteredEvent, AlertLimitByExpenseType alertLimitET) {

            ExpenseType eT = expenseRegisteredEvent.getExpenseType();

            CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount account = repo.theAccount();

            BigDecimal total = BigDecimal.ZERO;
            double count = 1.0;
            Map<ExpenseType, List<Expense>> map = account.getExpensesClassifiedByExpenseType();

            //TODO: improve this code
            for (Map.Entry<ExpenseType, List<Expense>> entry : map.entrySet()) {
                  if (entry.getKey().getDescription().equalsIgnoreCase(eT.getDescription())) {
                        total = sumAmount(entry.getValue());
                        count += (entry.getValue()).size();
                  }
            }
            BigDecimal amount = expenseRegisteredEvent.getAmount();
            total = total.add(amount);
            BigDecimal average=BigDecimal.ZERO;
            count++;
            if(count>0){
            average = total.divide(new BigDecimal(count),2, RoundingMode.CEILING);
            }
            AlertEventByExpenseType alertEvent = buildAlertEventByExpenseType(alertLimitET, amount, average, eT);
            return alertEvent;
      }

      private BigDecimal sumAmount(List<Expense> list) {
            BigDecimal total = new BigDecimal(0);
            for (Expense exp : list) {
                  total = total.add(exp.getAmount());
            }
            return total;
      }

      private AlertEventByExpenseType buildAlertEventByExpenseType(AlertLimitByExpenseType alertLimitET, BigDecimal amount, BigDecimal average,  ExpenseType eT) {

             double red =  alertLimitET.getPercentLimitRed();
            double yellow = alertLimitET.getPercentLimitYellow();
            BigDecimal yellowLim = average.multiply(new BigDecimal(yellow));
            BigDecimal redLim = average.multiply(new BigDecimal(red));
            
            AlertEventByExpenseType alert = null;
            int level1 = compareDeviation(amount, average, yellowLim, redLim);
            switch (level1) {
                  case 0:
                        break;
                  case 1:
                        this.setChanged();
                        alert = new AlertEventByExpenseType(alertLimitET.getAlertType().getDescription(), yellow, red, amount, average,"YELLOW", eT);
                        break;
                  case 2:
                        this.setChanged();
                        alert = new AlertEventByExpenseType(alertLimitET.getAlertType().getDescription(), yellow, red, amount,average, "RED", eT);
                        break;
            }
            return alert;
      }

      private int compare(BigDecimal expenditure, BigDecimal yellow, BigDecimal red) {
            if (expenditure.compareTo(red) >= 0) {
                  return 2;
            }
            if (expenditure.compareTo(yellow) >= 0) {
                  return 1;
            }
            return 0;
      }

      private int compareBalance(BigDecimal balance, BigDecimal yellow, BigDecimal red) {
            if (balance.compareTo(red) <= 0) {
                  return 2;
            }
            if (balance.compareTo(yellow) <= 0) {
                  return 1;
            }
            return 0;
      }

      private int compareDeviation(BigDecimal valor, BigDecimal average, BigDecimal yellow, BigDecimal red) {
            BigDecimal limMinYellow = average.subtract(yellow);
            BigDecimal limMaxYellow = average.add(yellow);
            BigDecimal limMinRed = average.subtract(red);
            BigDecimal limMaxRed = average.add(red);

            if ((valor.compareTo(limMinRed) <= 0) || (valor.compareTo(limMaxRed) >= 0)) {
                  return 2;
            }
            if ((valor.compareTo(limMinYellow) <= 0) || (valor.compareTo(limMaxYellow) >= 0)) {
                  return 1;
            }
            return 0;
      }
}
