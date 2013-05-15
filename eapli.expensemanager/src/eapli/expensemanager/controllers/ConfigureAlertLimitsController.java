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
        return PersistenceFactory.buildPersistenceFactory().expenseTypeRepository().all();
    }

    public AlertLimit findAlertLimitByType(AlertLimitType aLertType) {
        AlertLimit alertLimit = AlertLimit.findByAlertType(aLertType);
        return alertLimit;

    }

    public AlertLimit findAlertLimitByExpType(ExpenseType eT) {
        AlertLimit alertLimit = AlertLimitByExpenseType.findAlertLimisByExpenseTpe(eT);
        return alertLimit;
    }

    public void registerAlertLimitExpenditure(AlertLimitType alertType, double yellowLimit, double redLimit) {
        new AlertLimitExpenditure(alertType, new BigDecimal(yellowLimit), new BigDecimal(redLimit)).save();
    }

    public void registerAlertLimitByExpenseType(AlertLimitType alertType, double yellowLimit, double redLimit, ExpenseType eT) {
        new AlertLimitByExpenseType(alertType, yellowLimit, redLimit, eT).save();
    }

    public void updateAlertLimitExpenditure(AlertLimitExpenditure alertLimitExpenditure, double yellow, double red) {
        alertLimitExpenditure.updateLimits(yellow, red);
    }

    public void updateAlertLimitByExpenseType(AlertLimitByExpenseType alertLimitByExpenseType, double yellow, double red) {
        alertLimitByExpenseType.updateLimits(yellow, red);
    }
}
