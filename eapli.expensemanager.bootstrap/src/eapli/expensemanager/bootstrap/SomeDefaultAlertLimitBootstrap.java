/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import static eapli.expensemanager.model.AlertLimitType.LIMIT_DEVIATION_BY_EXPENSE_TYPE;
import static eapli.expensemanager.model.AlertLimitType.LIMIT_MINIMUM_BALANCE;
import static eapli.expensemanager.model.AlertLimitType.LIMIT_MONTH_EXPENDITURE;
import static eapli.expensemanager.model.AlertLimitType.LIMIT_WEEK_EXPENDITURE;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mcn
 */
public class SomeDefaultAlertLimitBootstrap implements Bootstrap {

    private static final BigDecimal LIMIT_WEEK_YELLOW = new BigDecimal(100);
    private static final BigDecimal LIMIT_WEEK_RED = new BigDecimal(500);
    private static final BigDecimal LIMIT_MONTH_YELLOW = new BigDecimal(600);
    private static final BigDecimal LIMIT_MONTH_RED = new BigDecimal(2000);
    private static final double LIMIT_DEVIATION_YELLOW = 0.1;
    private static final double LIMIT_DEVIATION_RED = 0.5;
    private static final BigDecimal LIMIT_BALANCE_YELLOW = new BigDecimal(1000);
    private static final BigDecimal LIMIT_BALANCE_RED = new BigDecimal(500);

    @Override
    public void bootstrap() {
        ensureLimitWeekExpenditureExists();

        ensureLimitMonthExpenditureExists();

        ensureLimitDeviationExists();

        ensureLimitMinimumBalanceExists();
    }

    private void ensureLimitWeekExpenditureExists() {
        if (AlertLimitExpenditure.findByAlertType(LIMIT_WEEK_EXPENDITURE) == null) {
            AlertLimitExpenditure alertLimitWeekExpenditure = new AlertLimitExpenditure(
                    LIMIT_WEEK_EXPENDITURE, LIMIT_WEEK_YELLOW, LIMIT_WEEK_RED);
            alertLimitWeekExpenditure.save();
        }
    }

    private void ensureLimitMonthExpenditureExists() {
        if (AlertLimitExpenditure.findByAlertType(LIMIT_MONTH_EXPENDITURE) == null) {
            AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(
                    LIMIT_MONTH_EXPENDITURE, LIMIT_MONTH_YELLOW, LIMIT_MONTH_RED);
            alertLimitMonthExpenditure.save();
        }
    }

    private void ensureLimitDeviationExists() {
        ExpenseTypeRepository repo = PersistenceFactory
                .buildPersistenceFactory().expenseTypeRepository();
        List<ExpenseType> expenseTypes = repo.all();
        for (ExpenseType eT : expenseTypes) {
            AlertLimitByExpenseType alertLimitET = new AlertLimitByExpenseType(
                    LIMIT_DEVIATION_BY_EXPENSE_TYPE, LIMIT_DEVIATION_YELLOW,
                    LIMIT_DEVIATION_RED, eT);
            alertLimitET.save();
        }
    }

    private void ensureLimitMinimumBalanceExists() {
        if (AlertLimitExpenditure.findByAlertType(LIMIT_MINIMUM_BALANCE) == null) {
            AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(
                    LIMIT_MINIMUM_BALANCE, LIMIT_BALANCE_YELLOW, LIMIT_BALANCE_RED);
            alertLimitMonthExpenditure.save();
        }
    }
}
