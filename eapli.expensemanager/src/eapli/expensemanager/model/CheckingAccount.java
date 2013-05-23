/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
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
public class CheckingAccount extends Observable implements Serializable {

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
	private List<Movement> movements;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "CheckingAccount_Expenses")
	private List<Expense> expenses;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "CheckingAccount_Incomes")
	private List<Income> incomes;
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
	 * eventough this is a public method if should not be used by code other
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
	 * NMB[2013-04-18] - alterei o método para publico, de forma a conseguir
	 * invocar para um conjunto específico de movimentos a partir do controller
	 * 
	 * @param theMovements
	 * @return BigDecimal
	 */
	// TODO: NMB: verificar se faz algum sentido passar para público ou se
	// deviamos
	// criar outro método ou fazer de outra forma qualquer
	// FIXME de um ponto de vista de API desta classe não faz sentido existir
	// este
	// método como public.
	public BigDecimal sumAmount(List<? extends Movement> theMovements) {
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
		BigDecimal i = new BigDecimal(0);
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
		List<Expense> expenses = getExpensesByType().get(expenseType);
		if (expenses == null || expenses.isEmpty()) {
			return BigDecimal.ZERO;
		}
		return sumAmount(expenses).divide(new BigDecimal(expenses.size()), 2,
				RoundingMode.UP);
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
}
