/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.persistence.ActiveRecord;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

/**
 *
 * @author mcn
 */
@Entity
@Inheritance
public class AlertLimit implements Serializable, ActiveRecord {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Enumerated(EnumType.STRING)
    protected AlertLimitType alertType;

    public AlertLimit() {
    }

    public AlertLimit(AlertLimitType alertType) {
        this.alertType = alertType;
    }

    public int getId() {
        return id;
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
        AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
        repo.save(this);
    }

    public static List<AlertLimit> loadAll() {
        AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
        return repo.all();
    }

    public static AlertLimit findByKey(int key) {
        AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
        return repo.findByKey(key);
    }

    public static AlertLimit findByAlertType(AlertLimitType al) {
        AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
        return repo.findByAlertType(al);
    }

    public static AlertLimit findAlertLimitsByExpenseType(ExpenseType eT) {
        AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
        return repo.findAlertLimitsByExpenseType(eT);
    }
}
