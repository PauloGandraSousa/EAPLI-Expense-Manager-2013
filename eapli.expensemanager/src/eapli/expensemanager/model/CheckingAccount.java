/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Long id;
    String owner;
    BigDecimal balance;
    @OneToMany
    List<Movement> movements;
    @Transient
    Map<Integer, List<Movement>> indexedMovements;
    final Integer EXPENSE_MOVEMENT_TYPE = new Integer(0);
    final Integer INCOME_MOVEMENT_TYPE = new Integer(1);

    public CheckingAccount() {
        //movements = new ArrayList();
        indexedMovements = new HashMap<Integer, List<Movement>>();
        indexedMovements.put(INCOME_MOVEMENT_TYPE, new ArrayList<Movement>());
        indexedMovements.put(EXPENSE_MOVEMENT_TYPE, new ArrayList<Movement>());

        // TODO load initial balance
        //balance = new BigDecimal(0);
    }

    public BigDecimal totalExpenditure() {
        List<Movement> theExpenses = indexedMovements.get(EXPENSE_MOVEMENT_TYPE);
        BigDecimal expenditure = new BigDecimal(0);
        for (Movement e : theExpenses) {
            expenditure = expenditure.add(e.amount);
        }
        return expenditure;
    }

    public void registerExpense(Expense expense) {
        movements.add(expense);
        List<Movement> theExpenses = indexedMovements.get(EXPENSE_MOVEMENT_TYPE);
        theExpenses.add(expense);
    }

    public void registerIncome(Income income) {
        movements.add(income);
        List<Movement> theIncomes = indexedMovements.get(INCOME_MOVEMENT_TYPE);
        theIncomes.add(income);
    }
}
