/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.presentation.charts.Chart;
import java.math.BigDecimal;
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
class ListExpensesUIPerTypeGUIChart extends ListExpensesUIPerTypeChart {

    /**
     * Lists all expense movements grouped by their type but it does not display
     * types with no movements
     *
     * @return
     */
    //TODO: NMB:pretende-se mostrar também tipos que não tenham movimentos?
    @Override
    public boolean doShow() {
        Map<ExpenseType, List<Expense>> mapExpenses = getController().getExpensesClassifiedByExpenseType();

        //TODO: NMB: Verificar se esta conversão deve ser efectuada aqui ou se deve vir do controller
        Map<ExpenseType, BigDecimal> mapExpensesSum = new HashMap<ExpenseType, BigDecimal>();
        for (Entry<ExpenseType, List<Expense>> entry : mapExpenses.entrySet()) {
            BigDecimal expenseSum = getController().sumAmount(entry.getValue());
            mapExpensesSum.put(entry.getKey(), expenseSum);
        }

        Chart demo = new Chart("Expenses per type chart");

        demo.setWindowTitle("Expenses per type chart");
        demo.setDomainAxisLabel("Expenses Type");
        demo.setRangeAxisLabel("Value");
        demo.setChartTitle("Expenses per type");

        //criar o dataSet a utilizar no gráfico
        demo.setDataset(mapExpensesSum);

        demo.doShow();


        return true;
    }

    @Override
    public String headline() {
        return super.headline() + " using graphical user interface";
    }
}
