/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import java.util.List;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;

/**
 * 
 * @author mcn
 */
public interface AlertLimitRepository {

	List<AlertLimit> all();

	AlertLimit save(AlertLimit alertLimit);

	AlertLimit findByKey(int i);

	AlertLimit findByAlertType(AlertLimitType a);

	AlertLimit findByExpenseType(ExpenseType eT);

	// FIXME the semantics we have for the save() method is "save or update", as
	// such having an explicit update() method is confusing - we should be using
	// save() instead
	AlertLimit update(AlertLimit al);
}
