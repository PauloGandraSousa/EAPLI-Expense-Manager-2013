/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.events;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
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

      public int getYearOcurred() {
            Date date = expenseRegistered.getDateOcurred();
            return DateTime.dateToCalendar(date).get(Calendar.YEAR);
      }

      public int getMonthOccurred() {
            Date date = expenseRegistered.getDateOcurred();
            return DateTime.dateToCalendar(date).get(Calendar.MONTH) + 1;
      }

      public int getWeekOccurred() {
            Date date = expenseRegistered.getDateOcurred();
            int week = DateTime.weekNumber(date);
            return week;
      }

      public BigDecimal getAmount() {
            return expenseRegistered.getAmount();

      }

      public ExpenseType getExpenseType() {
            return expenseRegistered.getExpenseType();
      }

      public Expense getExpenseRegistered() {
            return expenseRegistered;
      }

      public AlertEventExpenditure IsOverLimitWeekExpenditure() {
            CheckingAccountRepository repo =
                    PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount account = repo.theAccount();
            int year = getYearOcurred();
            int week = getWeekOccurred();
            BigDecimal expenditure;
            expenditure = account.expenditureOfWeek(year, week);
            //Because the event registered is not saved yet
            expenditure = expenditure.add(getAmount());
            return buildAlertEvent(expenditure, AlertLimitType.LIMIT_WEEK_EXPENDITURE);
      }

      public AlertEventExpenditure IsOverLimitMonthExpenditure() {
            CheckingAccountRepository repo =
                    PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount account = repo.theAccount();
            int year = getYearOcurred();
            int month = getMonthOccurred();
            BigDecimal expenditure;
            expenditure = account.expenditureOfMonth(year, month);
            //Because the event registered is not saved yet
            expenditure = expenditure.add(getAmount());
            return buildAlertEvent(expenditure, AlertLimitType.LIMIT_MONTH_EXPENDITURE);
      }

      public AlertEventExpenditure buildAlertEvent(BigDecimal expenditure, AlertLimitType alertType) {
            AlertLimitExpenditure alertLimit = (AlertLimitExpenditure) AlertLimit.findByAlertType(alertType);
            if (alertLimit != null) {
                  if (expenditure.compareTo(alertLimit.getLimitRed()) > 0) {
                        return new AlertEventExpenditure(alertLimit.getAlertType().getDescription(),
                                alertLimit.getLimitYellow(), alertLimit.getLimitRed(), expenditure, "RED");
                  }
                  if (expenditure.compareTo(alertLimit.getLimitYellow()) > 0) {
                        return new AlertEventExpenditure(alertLimit.getAlertType().getDescription(),
                                alertLimit.getLimitYellow(), alertLimit.getLimitRed(), expenditure, "YELLOW");
                  }
                  return null;
            }
            return null;
      }

      public AlertEventByExpenseType IsOverLimitDeviationByExpenseType() {
            AlertLimitRepository alertLimitRepo =
                    PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            ExpenseType eT = getExpenseType();
            AlertLimitByExpenseType alertLimitET = (AlertLimitByExpenseType) alertLimitRepo.findByExpenseType(eT);
            if (alertLimitET != null) {
                  CheckingAccountRepository repo =
                          PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
                  CheckingAccount account = repo.theAccount();
                  BigDecimal average = account.averageExpenditure(eT);
                  return buildAlertEventDeviation(getAmount(), average, alertLimitET);
            }
            return null;
      }

      private AlertEventByExpenseType buildAlertEventDeviation(BigDecimal amount,
              BigDecimal average, AlertLimitByExpenseType alertLimitET) {
            double yellowPercent = alertLimitET.getPercentLimitYellow();
            double redPercent = alertLimitET.getPercentLimitRed();
            BigDecimal yellow = average.multiply(new BigDecimal(yellowPercent));
            BigDecimal red = average.multiply(new BigDecimal(redPercent));
            BigDecimal limMinYellow = average.subtract(yellow);
            BigDecimal limMaxYellow = average.add(yellow);
            BigDecimal limMinRed = average.subtract(red);
            BigDecimal limMaxRed = average.add(red);

            if ((amount.compareTo(limMinRed) <= 0) || (amount.compareTo(limMaxRed) >= 0)) {
                  return new AlertEventByExpenseType(alertLimitET.getAlertType().getDescription(),
                          yellowPercent, redPercent, amount, average, "RED", alertLimitET.getExpenseType());
            }
            if ((amount.compareTo(limMinYellow) <= 0) || (amount.compareTo(limMaxYellow) >= 0)) {
                  return new AlertEventByExpenseType(alertLimitET.getAlertType().getDescription(),
                          yellowPercent, redPercent, amount, average, "YELLOW", alertLimitET.getExpenseType());
            }
            return null;
      }
}
