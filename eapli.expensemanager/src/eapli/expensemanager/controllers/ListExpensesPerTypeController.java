/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Podia adoptar por 1) especializar o controller de ListExpenses ou 2) criar um
 * novo. Neste caso, segui a abordagem da especialização 1).
 *
 * @author Nuno Bettencourt
 */
public class ListExpensesPerTypeController extends ListExpensesController {

    /**
     * Este método permite devolver todas as despesas do repositório agrupadas
     * por tipo Pode ser feito usando várias formas: <ul><ol> 1) obter todos os
     * tipos possíveis e para cada um deles obter o somatório mensal daquele
     * tipo</ol></ul>
     *
     * @return List<Expense> <p>O retorno não pode ser uma lista de despesas,
     * pois queremos uma lista de despesas por tipo de desdesa. Logo existiriam
     * duas abordagens: <ul><ol>1) Devolver uma lista em que cada elemento tem
     * um par de valores (tipo_de_despesa, valor)</ol><ol>2) Devolver uma lista
     * de objectos ExpenseListPerType, que contém uma lista de despesas e
     * consegue calcular o seu resultado on the fly</ol></ul></p>
     */
    public Map<ExpenseType, List<Expense>> getExpensesClassificedByExpenseType() {
        CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();
        return account.getExpensesClassifiedByExpenseType();
    }

    /**
     * Permite obter o valor para um conjunto de registos
     *
     * @param theMovements
     * @return BigDecimal - o valor somado dos movimentos passados
     */
    public BigDecimal sumAmount(List<? extends Movement> theMovements) {
        CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount();
        return account.sumAmount(theMovements);
    }
}
