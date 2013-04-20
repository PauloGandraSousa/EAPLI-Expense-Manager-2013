/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Para se criar o UI para os agregadores de despesa, existe a possibilidade de
 * se especializar a classe ListExpensesUI, que é semelhante ou criar-se uma
 * nova. 1) Para se manter independência entre os casos de uso, não se deve
 * especializar a classe ListExpensesUI. 2) Se não houver problemas em haver
 * dependências, então pode-se especializar a classe ListExpensesUI
 *
 * @author Nuno Bettencourt
 */
class ListExpensesUIPerTypeTextChart extends ListExpensesUIPerTypeChart {

    public void showExpenses(List<Expense> expenseList) {
        int position = 1;
        for (Expense expense : expenseList) {
            System.out.print(position + ". ");
            System.out.print(expense.getDateOcurred() + " ");
            System.out.print(expense.getAmount() + " ");
            System.out.println(expense.getDescription());
            position++;
        }
    }

    /**
     * Lists all expense movements grouped by their type it does not display
     * types with no movements
     *
     * @return
     */
    //TODO: NMB: pretende-se mostrar também tipos que não tenham movimentos?
    @Override
    public boolean doShow() {
        Map<ExpenseType, List<Expense>> mapExpenses = getController().getExpensesClassifiedByExpenseType();

        //TODO: NMB: Verificar se esta conversão deve ser efectuada aqui ou se deve vir do controller
        Map<ExpenseType, BigDecimal> mapExpensesSum = new HashMap<ExpenseType, BigDecimal>();

        //obter o valor máximo possível de todos os tipos de despesa para efectuar a conversão
        BigDecimal maxExpense = new BigDecimal(BigInteger.ZERO);
        for (Entry<ExpenseType, List<Expense>> entry : mapExpenses.entrySet()) {
            BigDecimal expenseSum = getController().sumAmount(entry.getValue());
            mapExpensesSum.put(entry.getKey(), expenseSum);
            if (expenseSum.compareTo(maxExpense) == 1) {
                maxExpense = expenseSum;
            }
        }
        //TODO: NMB quem criar o somatório?
        for (Entry<ExpenseType, BigDecimal> entry : mapExpensesSum.entrySet()) {
            BigDecimal expenseSumConverted = simpleLinearConversion(BigDecimal.ZERO, maxExpense, BigDecimal.ZERO, BigDecimal.TEN, entry.getValue());
            System.out.println(String.format("%-20s:", entry.getKey().getDescription() + "(" + entry.getValue() + ")") + String.format("%-" + expenseSumConverted.intValue() + "s", "").replace(' ', '*'));
        }
        return true;
    }

    @Override
    public String headline() {
        return super.headline() + " using text";
    }
}
