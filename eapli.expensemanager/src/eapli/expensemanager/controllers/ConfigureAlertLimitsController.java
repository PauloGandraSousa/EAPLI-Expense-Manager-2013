/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

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

    public AlertLimitExpenditure findAlertLimitByType(AlertLimitType aLertType) {
        AlertLimitExpenditure alertLimits = AlertLimitExpenditure.findByAlertType(aLertType);
        return alertLimits;
    }

    public AlertLimitByExpenseType findAlertLimitByExpType(ExpenseType eT) {
        AlertLimitByExpenseType alertLimits = AlertLimitByExpenseType.findByExpenseType(eT);
        return alertLimits;
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
