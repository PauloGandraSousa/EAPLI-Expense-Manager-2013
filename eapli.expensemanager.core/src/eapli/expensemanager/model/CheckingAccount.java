/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.expensemanager.model.events.ExpenseRegisteredEvent;
import eapli.expensemanager.model.exceptions.InsufficientBalanceException;
import eapli.expensemanager.model.report.ExpensesReport;
import eapli.framework.visitor.Visitable;
import eapli.framework.visitor.Visitor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class CheckingAccount extends Observable implements Serializable,
		Visitable<Movement> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
    // private String owner;
	// private BigDecimal balance;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "CheckingAccount_Movements")
	private final List<Movement> movements;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "CheckingAccount_Expenses")
	private final List<Expense> expenses;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "CheckingAccount_Incomes")
	private final List<Income> incomes;
	@OneToOne(cascade = CascadeType.MERGE)
	private InitialBalance initialBalance;
    // @ManyToMany
	// @ElementCollection(fetch = FetchType.EAGER)
	// @CollectionTable(name = "CheckingAccount_Expenses_by_ExpenseType")
	// @MapKeyColumn(name = "ExpenseType_ID")
	// @Column(name = "Expense_ID")
	@Transient
	private Map<ExpenseType, List<Expense>> expensesByType;

	public CheckingAccount() {
		super();
		// create empty list for using with in memory repositories
		movements = new ArrayList<Movement>();
		expenses = new ArrayList<Expense>();
		incomes = new ArrayList<Income>();
	}

	private Map<ExpenseType, List<Expense>> getExpensesByType() {
		if (expensesByType == null) {
			expensesByType = new HashMap<ExpenseType, List<Expense>>();
			reClassifyMovements();
		}
		return expensesByType;
	}

	/**
	 * checks if the object already has an id assigned by the persistence layer
	 * even tough this is a public method if should not be used by code other
	 * than the persistence layer
	 *
	 * @return
	 */
	public boolean hasId() {
		return id != null;
	}

	public BigDecimal totalExpenditure() {
		return sumAmount(getExpenses());
	}

	public BigDecimal totalEarnings() {
		return sumAmount(getIncomes());
	}

	public void registerIncome(Income income) {
		addMovement(income);
		classifyMovementAsIncome(income);
		// TODO should publish an event
	}

	/**
	 *
	 * @param theMovements
	 * @return BigDecimal
	 */
	private BigDecimal sumAmount(List<? extends Movement> theMovements) {
		BigDecimal sum = new BigDecimal(0);
		for (Movement e : theMovements) {
			sum = sum.add(e.getAmount());
		}
		return sum;
	}

	public void registerExpense(Expense expense)
			throws InsufficientBalanceException {
		if (!hasEnoughBalance(expense.getAmount())) {
			throw new InsufficientBalanceException(getBalance(),
												   expense.getAmount());
		}
		addMovement(expense);
		classifyMovementAsExpense(expense);
		classifyExpense(expense);
		publishEvent(expense);
	}

	private void publishEvent(Expense expense) {
		// ObserverPattern - Cria um evento e notifica Observers
		this.setChanged();
		ExpenseRegisteredEvent expenseRegisteredEvent = new ExpenseRegisteredEvent(
				expense);
		this.notifyObservers(expenseRegisteredEvent);
	}

	public void registerSavingDeposit(SavingDeposit savingDeposit)
			throws InsufficientBalanceException {
		if (!hasEnoughBalance(savingDeposit.getAmount())) {
			throw new InsufficientBalanceException(getBalance(),
												   savingDeposit.getAmount());
		}
		addMovement(savingDeposit);
		// TODO should publish an event
	}

	public void registerSavingWithdraw(SavingWithdraw savingWithdraw) {
		addMovement(savingWithdraw);
		// TODO should publish an event
	}

	private void classifyMovementAsExpense(Expense expense) {
		expenses.add(expense);
	}

	/**
	 *
	 * @param expense
	 */
	private void classifyExpense(Expense expense) {
		List<Expense> theExpenses = getExpensesByType().get(
				expense.getExpenseType());
		if (theExpenses == null) {
			theExpenses = new ArrayList<Expense>();
			getExpensesByType().put(expense.getExpenseType(), theExpenses);
		}
		theExpenses.add(expense);
	}

	private void classifyMovementAsIncome(Income income) {
		incomes.add(income);
	}

	public List<Movement> getMovements() {
		return Collections.unmodifiableList(movements);
	}

	public List<Expense> getExpenses() {
		return Collections.unmodifiableList(expenses);
	}

	public List<Income> getIncomes() {
		return Collections.unmodifiableList(incomes);
	}

	/**
	 * Permite reclassificar os tipos de movimentos em despesa e receitas
	 */
	private void reClassifyMovements() {
		// TODO verificar se é necessário classificar os movimentos

		for (Movement movement : getMovements()) {
			if (movement instanceof Expense) {
				classifyExpense((Expense) movement);
			}
		}
	}

	public ExpensesReport getExpensesAggregatedByType(Date inicialPeriod,
													  Date finalPeriod) {

		ExpensesReport expenseReport = new ExpensesReport();

		for (Expense expense : getExpenses()) {
			expenseReport.aggregate(expense);
		}

		return expenseReport;
	}

	public Map<ExpenseType, List<Expense>> getExpensesClassifiedByExpenseType() {
		return Collections.unmodifiableMap(getExpensesByType());
	}

	private void addMovement(Movement movement) throws IllegalArgumentException {
		if (movement == null) {
			throw new IllegalArgumentException();
		}

		movements.add(movement);
	}

	private boolean hasEnoughBalance(BigDecimal amount) {
        // TODO given the name of the method is would be more logic to make the
		// comparison from the getBalance object to the amount object
		if (amount.compareTo(getBalance()) == 1) {
			return false;
		}

		return true;
	}

	/**
	 * get the current balance of the account
	 *
	 * @return
	 */
	public BigDecimal getBalance() {
		BigDecimal i = BigDecimal.ZERO;
		if (initialBalance != null) {
			i = initialBalance.getValue();
		}

		/*
		 * calculates the balance of the account. alternatively, the balance
		 * could be a persistent attribute allways up to-date
		 */
		return totalEarnings().subtract(totalExpenditure()).add(i);
	}

	public void registerInitialBalance(InitialBalance initial) {
		if (initial == null || hasInitialBalance()) {
			throw new IllegalArgumentException();
		}
		initialBalance = initial;
	}

	private boolean hasInitialBalance() {
		return initialBalance != null;
	}

	public BigDecimal averageExpenditure(ExpenseType expenseType) {
		List<Expense> expensesOfType = getExpensesByType().get(expenseType);
		if (expensesOfType == null || expensesOfType.isEmpty()) {
			return BigDecimal.ZERO;
		}
		return sumAmount(expensesOfType).divide(
				new BigDecimal(expensesOfType.size()), 2, RoundingMode.UP);
	}

	public BigDecimal expenditureOfMonth(int year, int month) {
		BigDecimal total = BigDecimal.ZERO;
		for (Expense expense : expenses) {
			if (expense.ocurredInMonth(year, month)) {
				total = total.add(expense.getAmount());
			}
		}
		return total;
	}

	public BigDecimal expenditureOfWeek(int year, int week) {
		BigDecimal total = BigDecimal.ZERO;
		for (Expense expense : expenses) {
			if (expense.ocurredInWeek(year, week)) {
				total = total.add(expense.getAmount());
			}
		}
		return total;
	}

	@Override
	public void accept(Visitor<Movement> visitor) {
		for (Movement aMovement : getMovements()) {
			visitor.beforeVisiting(aMovement);
			visitor.visit(aMovement);
			visitor.afterVisiting(aMovement);
		}
	}
}
