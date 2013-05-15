/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mcn
 */
public class SomeDefaultAlertLimitBootstrap {

    private final BigDecimal LIMIT_WEEK_YELLOW = new BigDecimal(100);
    private final BigDecimal LIMIT_WEEK_RED = new BigDecimal(500);
    private final BigDecimal LIMIT_MONTH_YELLOW = new BigDecimal(600);
    private final BigDecimal LIMIT_MONTH_RED = new BigDecimal(2000);
    private final double LIMIT_DEVIATION_YELLOW = 0.1;
    private final double LIMIT_DEVIATION_RED = 0.5;
    private final BigDecimal LIMIT_BALANCE_YELLOW = new BigDecimal(600);
    private final BigDecimal LIMIT_BALANCE_RED = new BigDecimal(2000);

    public SomeDefaultAlertLimitBootstrap() {
        AlertLimitType[] types = AlertLimitType.values();
        if (types.length == 0) {
            return;
        }

        for (AlertLimitType alertLimitType : types) {
            switch (alertLimitType) {
                case LIMIT_WEEK_EXPENDITURE:
                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
                        AlertLimitExpenditure alertLimitWeekExpenditure = new AlertLimitExpenditure(alertLimitType, LIMIT_WEEK_YELLOW, LIMIT_WEEK_RED);
                        alertLimitWeekExpenditure.save();
                    }
                    break;

                case LIMIT_MONTH_EXPENDITURE:
                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
                        AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(alertLimitType, LIMIT_MONTH_YELLOW, LIMIT_MONTH_RED);
                        alertLimitMonthExpenditure.save();
                    }
                    break;

                case LIMIT_DEVIATION_BY_EXPENSE_TYPE:
                    ExpenseTypeRepository repo = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
                    List<ExpenseType> list = repo.all();
                    AlertLimitByExpenseType alertLimitET;
                    for (ExpenseType eT : list) {
                        alertLimitET = new AlertLimitByExpenseType(alertLimitType, LIMIT_DEVIATION_YELLOW, LIMIT_DEVIATION_RED, eT);
                        alertLimitET.save();
                    }
                    break;

                case LIMIT_MINIMUM_BALANCE:
                    if (AlertLimitExpenditure.findByAlertType(alertLimitType) == null) {
                        AlertLimitExpenditure alertLimitMonthExpenditure = new AlertLimitExpenditure(alertLimitType, LIMIT_MONTH_YELLOW, LIMIT_MONTH_RED);
                        alertLimitMonthExpenditure.save();

                    }
                    break;
            }
        }
    }
}
