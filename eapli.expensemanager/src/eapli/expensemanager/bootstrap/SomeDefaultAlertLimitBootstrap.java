/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
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

    private final BigDecimal LIMIT_WEEK_YELLOW = new BigDecimal(100);
    private final BigDecimal LIMIT_WEEK_RED = new BigDecimal(500);
    private final BigDecimal LIMIT_MONTH_YELLOW = new BigDecimal(600);
    private final BigDecimal LIMIT_MONTH_RED = new BigDecimal(2000);
    private final double LIMIT_DEVIATION_YELLOW = 0.1;
    private final double LIMIT_DEVIATION_RED = 0.5;
    private final BigDecimal LIMIT_BALANCE_YELLOW = new BigDecimal(600);
    private final BigDecimal LIMIT_BALANCE_RED = new BigDecimal(2000);

    @Override
    public void bootstrap() {
        AlertLimitType[] types = AlertLimitType.values();
        if (types.length == 0) {
            return;
        }

        // TODO do we really need this for loop with a switch inside?
        for (AlertLimitType alertLimitType : types) {
            switch (alertLimitType) {
                case LIMIT_WEEK_EXPENDITURE:
                    ensureLimitWeekExpenditureExists(alertLimitType);
                    break;

                case LIMIT_MONTH_EXPENDITURE:
                    ensureLimitMonthExpenditureExists(alertLimitType);
                    break;

                case LIMIT_DEVIATION_BY_EXPENSE_TYPE:
                    ensureLimitDeviationExists(alertLimitType);
                    break;

                case LIMIT_MINIMUM_BALANCE:
                    ensureLimitMinimumBalanceExists(alertLimitType);
                    break;
            }
        }
    }

    private void ensureLimitWeekExpenditureExists(final AlertLimitType alertLimitType) {
        if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
            AlertLimitExpenditure alertLimitWeekExpenditure = new AlertLimitExpenditure(alertLimitType, LIMIT_WEEK_YELLOW, LIMIT_WEEK_RED);
            alertLimitWeekExpenditure.save();
        }
    }

    private void ensureLimitMonthExpenditureExists(AlertLimitType alertLimitType) {
        if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
            AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(alertLimitType, LIMIT_MONTH_YELLOW, LIMIT_MONTH_RED);
            alertLimitMonthExpenditure.save();
        }
    }

    private void ensureLimitDeviationExists(final AlertLimitType alertLimitType) {
        ExpenseTypeRepository repo = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
        List<ExpenseType> expenseTypes = repo.all();
        for (ExpenseType eT : expenseTypes) {
            AlertLimitByExpenseType alertLimitET = new AlertLimitByExpenseType(alertLimitType, LIMIT_DEVIATION_YELLOW, LIMIT_DEVIATION_RED, eT);
            alertLimitET.save();
        }
    }

    private void ensureLimitMinimumBalanceExists(final AlertLimitType alertLimitType) {
        if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
            AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(alertLimitType, LIMIT_BALANCE_YELLOW, LIMIT_BALANCE_RED);
            alertLimitMonthExpenditure.save();
        }
    }
}
