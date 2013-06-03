/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import eapli.util.DateTime;

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

	public Expense(ExpenseType type, String description, Date dateOccurred,
			BigDecimal amount, Payment payment) {
		super(description, dateOccurred, amount);
		if (type == null || payment == null) {
			throw new IllegalArgumentException();
		}
		this.type = type;
		this.payment = payment;
	}

	public Expense(ExpenseType type, String description, int year, int month,
			int day, BigDecimal amount, Payment payment) {
		this(type, description, DateTime.newDate(year, month, day), amount,
				payment);
	}

	public ExpenseType getExpenseType() {
		return type;
	}

	@Override
	public String toXml() {
		return "<expense>" + super.toXml() + type.toXml() + payment.toXml()
				+ "</expense>";
	}

	@Override
	public String toCsv() {
		return "Expense," + super.toCsv() + type.toCsv() + payment.toCsv();
	}

	public Payment getPayment() {
		return payment;
	}
}
