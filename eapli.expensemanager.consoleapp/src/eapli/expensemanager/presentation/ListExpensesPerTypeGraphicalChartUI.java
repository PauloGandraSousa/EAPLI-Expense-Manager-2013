/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.report.ExpensesReport;
import eapli.expensemanager.presentation.charts.ChartImpl;

/**
 * Para se criar o UI para os agregadores de despesa, existe a possibilidade de
 * se especializar a classe ListExpensesUI, que é semelhante ou criar-se uma
 * nova. 1) Para se manter independência entre os casos de uso, não se deve
 * especializar a classe ListExpensesUI. 2) Se não houver problemas em haver
 * dependências, então pode-se especializar a classe ListExpensesUI
 *
 * @author Nuno Bettencourt
 */
class ListExpensesPerTypeGraphicalChartUI extends ListExpensesPerTypeChartBaseUI {

    /**
     * Lists all expense movements grouped by their type but it does not display
     * types with no movements
     *
     * @return
     */
    //TODO: NMB:pretende-se mostrar também tipos que não tenham movimentos?
    @Override
    public boolean doShow() {
        ExpensesReport expenseReport = getController().getExpensesClassifiedByExpenseType();

        ChartImpl demo = new ChartImpl("Expenses per type chart");

        demo.setWindowTitle("Expenses per type chart");
        demo.setDomainAxisLabel("Expenses Type");
        demo.setRangeAxisLabel("Value");
        demo.setChartTitle("Expenses per type");

        //criar o dataSet a utilizar no gráfico
        demo.setDataset(expenseReport);

        demo.doShow();

        return true;
    }

    @Override
    public String headline() {
        return super.headline() + " using graphical user interface";
    }
}
