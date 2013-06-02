/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.ListExpensesPerTypeController;

/**
 * Para se criar o UI para os agregadores de despesa, existe a possibilidade de
 * se especializar a classe ListExpensesUI, que é semelhante ou criar-se uma
 * nova. 1) Para se manter independência entre os casos de uso, não se deve
 * especializar a classe ListExpensesUI. 2) Se não houver problemas em haver
 * dependências, então pode-se especializar a classe ListExpensesUI
 *
 * @author Nuno Bettencourt
 */
abstract class ListExpensesPerTypeChartBaseUI extends BaseUI {

    private ListExpensesPerTypeController controller = new ListExpensesPerTypeController();

    @Override
    protected ListExpensesPerTypeController getController() {
        return controller;
    }

    @Override
    public String headline() {
        return "LIST EXPENSES PER TYPE CHART";
    }
}
