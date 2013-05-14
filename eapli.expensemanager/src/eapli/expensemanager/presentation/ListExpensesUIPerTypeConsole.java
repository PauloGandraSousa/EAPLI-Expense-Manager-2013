/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.ListExpensesPerTypeController;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
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
class ListExpensesUIPerTypeConsole extends ListExpensesUI {

    /**
     * Poderia ter criado um set getController no ListExpensesUI, mas isso
     * desvirtuava o conceito de ui ligado a um único controlador. Sendo assim,
     * adoptei a opção de crira um atributo privado que tem o getController
     * necessário. <p>Quem faz o cálculo dos agrupados? UI, Controller ou
     * CheckingAccount?</p>
     */
    private ListExpensesPerTypeController controller = new ListExpensesPerTypeController();

    private void showExpenses(List<Expense> expenseList) {
        int position = 1;
        for (Expense expense : expenseList) {
            System.out.print("\t");
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
    //TODO: NMB:pretende-se mostrar também tipos que não tenham movimentos?
    @Override
    public boolean doShow() {
        Map<ExpenseType, List<Expense>> mapExpenses = controller.getExpensesClassifiedByExpenseType();
        for (Entry<ExpenseType, List<Expense>> entry : mapExpenses.entrySet()) {
            System.out.print(entry.getKey().getDescription());
            System.out.println("\tTotal amount:" + controller.sumAmount(entry.getValue()));
            showExpenses(entry.getValue());
        }

        return true;
    }

    @Override
    public String headline() {
        return "LIST EXPENSES PER TYPE";
    }
}
