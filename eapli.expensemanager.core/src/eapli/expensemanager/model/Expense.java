/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Paulo Gandra Sousa
 */
@Entity
public class Expense extends Movement {

	/**
     *
     */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.MERGE)
	private ExpenseType type;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Payment payment;

	protected Expense() {
	}

	public Expense(ExpenseType type, String description, Calendar dateOccurred,
			BigDecimal amount, Payment payment, String[] tags) {
		super(description, dateOccurred, amount, tags);
		init(type, payment);
	}

	public Expense(ExpenseType type, String description, Calendar dateOccurred, BigDecimal amount, Payment payment) {
		super(description, dateOccurred, amount);
		init(type, payment);
	}

	public Expense(ExpenseType type, String description, int year, int month, int day, BigDecimal amount, Payment payment) {
		this(type, description, DateTime.newCalendar(year, month, day), amount,
																		payment);
	}

	private void init(ExpenseType type, Payment payment) {
		if (type == null || payment == null) {
			throw new IllegalArgumentException();
		}
		this.type = type;
		this.payment = payment;
	}

	public ExpenseType getExpenseType() {
		return type;
	}

	public Payment getPayment() {
		return payment;
	}
}
