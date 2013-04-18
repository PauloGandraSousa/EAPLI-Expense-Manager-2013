/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class CheckingAccount {

    @Id
    @GeneratedValue
    private Long id;
    private String owner;
    private BigDecimal balance;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Movement> movements;
    @Transient
    private List<Expense> expenses;
    @Transient
    private List<Income> incomes;
    @Transient
    private Map<ExpenseType, List<Expense>> expensesByType;

    public CheckingAccount() {
        //movements = new ArrayList();

        expenses = new ArrayList();

        incomes = new ArrayList();

        expensesByType = new HashMap<ExpenseType, List<Expense>>();

        // TODO load initial balance
        //balance = new BigDecimal(0);

    }

    public BigDecimal totalExpenditure() {
        return sumAmount(expenses);
    }

    public BigDecimal totalEarnings() {
        return sumAmount(incomes);
    }

    public void registerIncome(Income income) {
        addMovement(income);
        classifyMovementAsIncome(income);
    }

    /**
     * NMB[2013-04-18] - alterei o método para publico, de forma a conseguir
     * invocar para um conjunto específico de movimentos a partir do controller
     *
     * @param theMovements
     * @return BigDecimal
     */
    //TODO: NMB: verificar se faz algum sentido passar para público ou se deviamos
    //criar outro método ou fazer de outra forma qualquer
    public BigDecimal sumAmount(List<? extends Movement> theMovements) {
        BigDecimal sum = new BigDecimal(0);
        for (Movement e : theMovements) {
            sum = sum.add(e.getAmount());
        }
        return sum;
    }

    public void registerExpense(Expense expense) {
        addMovement(expense);
        classifyMovementAsExpense(expense);
        classifyExpense(expense);
    }

    private void classifyMovementAsExpense(Expense expense) {
        expenses.add(expense);
    }

    /**
     * NMB[2013-04-18] Changed the method so that it could also sum the total of
     * expenses in the list
     *
     * @param expense
     */
    private void classifyExpense(Expense expense) {
        List<Expense> theExpenses = expensesByType.get(expense.getExpenseType());
        if (theExpenses == null) {
            theExpenses = new ArrayList<Expense>();
            expensesByType.put(expense.getExpenseType(), theExpenses);
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
        //Verificar se existem o total de movimentos é igual ao total de
        // despesas e de receitas
        if (movements.size() != (expenses.size() + incomes.size())) {
            //se não for, é necessário classificar os movimentos
            for (Movement movement : movements) {
                if (movement instanceof Expense) {
                    classifyMovementAsExpense((Expense) movement);
                    classifyExpense((Expense) movement);
                } else {
                    //TODO: falta o código para classificar uma receita
                }
            }
        }
    }

    public Map<ExpenseType, List<Expense>> getExpensesClassifiedByExpenseType() {
        /*
         * NMB:o problema de ter este reclassificador é que obriga sempre a obter
         * todos  registos que se encontrem na base de dados
         */
        //TODO: verificar se é para manter o reClassifyMovements ou se a pesquisa
        //é sempre feita ondemand. Tentei colocar no construtor mas não funciona
        reClassifyMovements();
        return Collections.unmodifiableMap(expensesByType);
    }

    private void addMovement(Movement movement) throws IllegalArgumentException {
        if (movement == null) {
            throw new IllegalArgumentException();
        }

        movements.add(movement);
    }
}
