/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.limits;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.events.ExpenseRegisteredEvent;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mcn
 */
public class LimitsWatchDog extends Observable implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ExpenseRegisteredEvent expenseRegisteredEvent = (ExpenseRegisteredEvent) arg;
        verifyLimits(expenseRegisteredEvent);
    }

    private void verifyLimits(ExpenseRegisteredEvent event) {
        checkIfIsOverLimitWeekExpenditure(event.getExpense());
        checkIfIsOverLimitMonthExpenditure(event.getExpense());
        checkIfIsOverLimitDeviationByExpenseType(event.getExpense());
        checkIfIsOverBalanceLimit(event);
    }

    /**
     * Only publish the event expenseregistred creates some events because was
     * considered the information expert
     */
    private void publishEvent(AlertEvent alert) {
        if (alert != null) {
            this.setChanged();
            notifyObservers(alert);
        }
    }

    private AlertEvent buildAlertBalanceEvent(AlertLimitExpenditure alertLimit,
                                              ExpenseRegisteredEvent expense) {
        CheckingAccountRepository repo = PersistenceFactory.
                buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();
        BigDecimal balance = account.getBalance();
        //Because the expense registered is not saved yet
        balance = balance.subtract(expense.getAmount());
        AlertEvent alert = buildAlertBalanceEvent(balance, alertLimit.
                getAlertType());
        return alert;
    }

    private ExpenditureOverLimitAlertEvent buildAlertBalanceEvent(
            BigDecimal balance,
            AlertLimitType alertType) {
        AlertLimitExpenditure alertLimit = (AlertLimitExpenditure) AlertLimit.
                findByAlertType(alertType);
        if (alertLimit != null) {
            if (balance.compareTo(alertLimit.getLimitRed()) < 0) {
                return new ExpenditureOverLimitAlertEvent(alertLimit.
                        getAlertType().
                        getDescription(),
                                                          alertLimit.
                        getLimitYellow(), alertLimit.
                        getLimitRed(), balance, "RED");
            }
            if (balance.compareTo(alertLimit.getLimitYellow()) < 0) {
                return new ExpenditureOverLimitAlertEvent(alertLimit.
                        getAlertType().
                        getDescription(),
                                                          alertLimit.
                        getLimitYellow(), alertLimit.
                        getLimitRed(), balance, "YELLOW");
            }
            return null;
        }
        return null;
    }

//    private int getYearOcurred() {
//        Date date = expenseRegistered.getDateOcurred();
//        return DateTime.dateToCalendar(date).get(Calendar.YEAR);
//    }
//
//    private int getMonthOccurred() {
//        Date date = expenseRegistered.getDateOcurred();
//        return DateTime.dateToCalendar(date).get(Calendar.MONTH) + 1;
//    }
//
//    private int getWeekOccurred() {
//        Date date = expenseRegistered.getDateOcurred();
//        int week = DateTime.weekNumber(date);
//        return week;
//    }

    /* ========================= */
    private void checkIfIsOverLimitWeekExpenditure(
            Expense expenseRegistered) {
        CheckingAccountRepository repo = PersistenceFactory
                .buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();

        int year = expenseRegistered.getOccurred().get(Calendar.YEAR);
        int week = expenseRegistered.getOccurred().get(Calendar.WEEK_OF_YEAR);

        BigDecimal expenditure = account.expenditureOfWeek(year, week);

        // Because the event registered is not saved yet
        expenditure = expenditure.add(expenseRegistered.getAmount());
        AlertEvent alert = buildAlertEvent(expenditure,
                                           AlertLimitType.LIMIT_WEEK_EXPENDITURE);
        publishEvent(alert);
    }

    private void checkIfIsOverLimitMonthExpenditure(
            Expense expenseRegistered) {
        CheckingAccountRepository repo = PersistenceFactory
                .buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();
        int year = expenseRegistered.getOccurred().get(Calendar.YEAR);
        int month = expenseRegistered.getOccurred().get(Calendar.MONTH);
        BigDecimal expenditure;
        expenditure = account.expenditureOfMonth(year, month);
        // Because the event registered is not saved yet
        expenditure = expenditure.add(expenseRegistered.getAmount());
        AlertEvent alert = buildAlertEvent(expenditure,
                                           AlertLimitType.LIMIT_MONTH_EXPENDITURE);
        publishEvent(alert);
    }

    private ExpenditureOverLimitAlertEvent buildAlertEvent(
            BigDecimal expenditure, AlertLimitType alertType) {
        AlertLimitExpenditure alertLimit = (AlertLimitExpenditure) AlertLimit
                .findByAlertType(alertType);
        if (alertLimit != null) {
            if (expenditure.compareTo(alertLimit.getLimitRed()) > 0) {
                return new ExpenditureOverLimitAlertEvent(alertLimit.
                        getAlertType().getDescription(), alertLimit.
                        getLimitYellow(), alertLimit.getLimitRed(), expenditure, "RED");
            }
            if (expenditure.compareTo(alertLimit.getLimitYellow()) > 0) {
                return new ExpenditureOverLimitAlertEvent(alertLimit
                        .getAlertType().getDescription(),
                                                          alertLimit.
                        getLimitYellow(), alertLimit.getLimitRed(),
                                                          expenditure, "YELLOW");
            }
            return null;
        }
        return null;
    }

    private void checkIfIsOverLimitDeviationByExpenseType(
            Expense expenseRegistered) {
        AlertLimitRepository alertLimitRepo = PersistenceFactory
                .buildPersistenceFactory().alertLimitRepository();
        ExpenseType eT = expenseRegistered.getExpenseType();
        AlertLimitByExpenseType alertLimitET = (AlertLimitByExpenseType) alertLimitRepo.
                findByExpenseType(eT);
        if (alertLimitET != null) {
            CheckingAccountRepository repo = PersistenceFactory
                    .buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount account = repo.theAccount();
            BigDecimal average = account.averageExpenditure(eT);
            AlertEvent alert = buildAlertEventDeviation(expenseRegistered.
                    getAmount(), average, alertLimitET);

            publishEvent(alert);

        }
    }

    private ExpenditureByExpenseTypeOverLimitAlertEvent buildAlertEventDeviation(
            BigDecimal amount, BigDecimal average,
            AlertLimitByExpenseType alertLimitET) {
        double yellowPercent = alertLimitET.getPercentLimitYellow();
        double redPercent = alertLimitET.getPercentLimitRed();
        BigDecimal yellow = average.multiply(new BigDecimal(yellowPercent));
        BigDecimal red = average.multiply(new BigDecimal(redPercent));
        BigDecimal limMinYellow = average.subtract(yellow);
        BigDecimal limMaxYellow = average.add(yellow);
        BigDecimal limMinRed = average.subtract(red);
        BigDecimal limMaxRed = average.add(red);

        if ((amount.compareTo(limMinRed) <= 0)
                || (amount.compareTo(limMaxRed) >= 0)) {
            return new ExpenditureByExpenseTypeOverLimitAlertEvent(alertLimitET
                    .getAlertType().getDescription(), yellowPercent,
                                                                   redPercent, amount, average, "RED",
                                                                   alertLimitET.
                    getExpenseType());
        }
        if ((amount.compareTo(limMinYellow) <= 0)
                || (amount.compareTo(limMaxYellow) >= 0)) {
            return new ExpenditureByExpenseTypeOverLimitAlertEvent(alertLimitET
                    .getAlertType().getDescription(), yellowPercent,
                                                                   redPercent, amount, average, "YELLOW",
                                                                   alertLimitET.
                    getExpenseType());
        }
        return null;
    }

    private void checkIfIsOverBalanceLimit(ExpenseRegisteredEvent event) {
        AlertLimitExpenditure alertLimitBalance = (AlertLimitExpenditure) AlertLimit.
                findByAlertType(AlertLimitType.LIMIT_MINIMUM_BALANCE);
        if (alertLimitBalance != null) {
            AlertEvent alert = buildAlertBalanceEvent(alertLimitBalance, event);
            publishEvent(alert);
        }
    }
}
