/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class CheckingAccount implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String owner;
    private BigDecimal balance;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "CheckingAccount_Movements")
    private List<Movement> movements;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "CheckingAccount_Expenses")
    private List<Expense> expenses;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "CheckingAccount_Incomes")
    private List<Income> incomes;
    
    
    //@ManyToMany
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "CheckingAccount_Expenses_by_ExpenseType")
//    @MapKeyColumn(name = "ExpenseType_ID")
//    @Column(name = "Expense_ID")
    @Transient
    private Map<ExpenseType, List<Expense>> expensesByType;

    public CheckingAccount() {
        expensesByType = new HashMap<ExpenseType, List<Expense>>();

        // TODO load initial balance
        //balance = new BigDecimal(0);
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
    // FIX de um ponto de vista de API desta classe não faz sentido existir este 
    // método como public.  
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
        // TODO verificar se é necessário classificar os movimentos

        for (Movement movement : getMovements()) {
            if (movement instanceof Expense) {
                classifyExpense((Expense) movement);
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
    
    
    //AJS: determina se existe valor suficiente para gastar numa despesa ou transferência
    // para poupança
    public boolean enoughBalance(BigDecimal amount)
    {
        // return 1 if bigger
        if(amount.compareTo(balance)==1)
            return false;
        
        return true;
    }
    
    
}
