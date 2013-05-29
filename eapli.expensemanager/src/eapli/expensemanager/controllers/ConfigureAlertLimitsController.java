/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mcn
 */
public class ConfigureAlertLimitsController extends BaseController {

    public AlertLimitType[] getAlertLimitTypes() {
        return AlertLimitType.values();
    }

    public List<ExpenseType> getAllExpenseTypes() {
        return PersistenceFactory.buildPersistenceFactory().
                expenseTypeRepository().all();
    }

    public AlertLimit findByAlertType(AlertLimitType aLertType) {
        return AlertLimit.findByAlertType(aLertType);
    }

    public AlertLimit findByExpenseType(ExpenseType eT) {
        return AlertLimitByExpenseType.findByExpenseType(eT);
    }

    public void registerAlertLimitExpenditure(AlertLimitType alertType,
                                              double yellowLimit,
                                              double redLimit) {
        AlertLimitExpenditure limit = new AlertLimitExpenditure(alertType, new BigDecimal(yellowLimit), new BigDecimal(redLimit));
        limit.save();
    }

    public void registerAlertLimitByExpenseType(AlertLimitType alertType,
                                                double yellowLimit,
                                                double redLimit, ExpenseType eT) {
        AlertLimitByExpenseType limit = new AlertLimitByExpenseType(alertType, yellowLimit, redLimit, eT);
        limit.save();
    }

    public void updateAlertLimitExpenditure(
            AlertLimitExpenditure alertLimitExpenditure,
            double yellow,
            double red) {
        alertLimitExpenditure.updateLimits(yellow, red);
        //Does not work because Entity is detached
        alertLimitExpenditure.save();
        //alertLimitExpenditure.update();
    }

    public void updateAlertLimitByExpenseType(
            AlertLimitByExpenseType alertLimitByExpenseType,
            double yellow,
            double red) {
        alertLimitByExpenseType.updateLimits(yellow, red);
        //Does not work because Entity is detached
        //alertLimitByExpenseType.save();
        alertLimitByExpenseType.update();
    }
}
