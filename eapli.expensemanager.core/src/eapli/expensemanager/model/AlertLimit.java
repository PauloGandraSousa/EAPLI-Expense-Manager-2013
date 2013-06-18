/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import eapli.framework.persistence.ActiveRecord;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;

/**
 * 
 * @author mcn
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AlertLimit implements Serializable, ActiveRecord {

	/**
     *
     */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	protected Long id;
	@Enumerated(EnumType.STRING)
	protected AlertLimitType alertType;

	public AlertLimit() {
	}

	public AlertLimit(AlertLimitType alertType) {
		this.alertType = alertType;
	}

	public AlertLimitType getAlertType() {
		return alertType;
	}

	@Override
	public String toString() {
		String str = "Alert Type:" + alertType;
		return str;
	}

	@Override
	public void save() {
		AlertLimitRepository repo = PersistenceFactory
				.buildPersistenceFactory().alertLimitRepository();
		// if (hasId()) {
		// repo.update(this);
		// } else {
		// repo.save(this);
		// }
		repo.save(this);
	}

	/**
	 * get all limits
	 * 
	 * active record method
	 * 
	 * @return
	 */
	public static List<AlertLimit> loadAll() {
		AlertLimitRepository repo = PersistenceFactory
				.buildPersistenceFactory().alertLimitRepository();
		return repo.all();
	}

	/**
	 * finds a specific limit by its key
	 * 
	 * @param key
	 * @return
	 */
	public static AlertLimit findByKey(int key) {
		AlertLimitRepository repo = PersistenceFactory
				.buildPersistenceFactory().alertLimitRepository();
		return repo.findByKey(key);
	}

	/**
	 * find a specific limit based on its Alert Type
	 * 
	 * @param al
	 * @return
	 */
	public static AlertLimit findByAlertType(AlertLimitType al) {
		AlertLimitRepository repo = PersistenceFactory
				.buildPersistenceFactory().alertLimitRepository();
		return repo.findByAlertType(al);
	}

	/**
	 * finds a specific limit based on the Expense Type
	 * 
	 * @param eT
	 * @return
	 */
	public static AlertLimit findByExpenseType(ExpenseType eT) {
		AlertLimitRepository repo = PersistenceFactory
				.buildPersistenceFactory().alertLimitRepository();
		return repo.findByExpenseType(eT);
	}

	public boolean hasId() {
		return (id == null ? false : true);
	}
}
