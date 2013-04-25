/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.ListExpensesPerTypeController;
import java.math.BigDecimal;
import java.math.RoundingMode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Para se criar o UI para os agregadores de despesa, existe a possibilidade de
 * se especializar a classe ListExpensesUI, que é semelhante ou criar-se uma
 * nova. 1) Para se manter independência entre os casos de uso, não se deve
 * especializar a classe ListExpensesUI. 2) Se não houver problemas em haver
 * dependências, então pode-se especializar a classe ListExpensesUI
 *
 * @author Nuno Bettencourt
 */
abstract class ListExpensesUIPerTypeChart extends ListExpensesUI {

    /**
     * Poderia ter criado um set controller no ListExpensesUI, mas isso
     * desvirtuava o conceito de ui ligado a um único controlador. Sendo assim,
     * adoptei a opção de crira um atributo privado que tem o controller
     * necessário. <p>Quem faz o cálculo dos agrupados? UI, Controller ou
     * CheckingAccount?</p>
     */
    private ListExpensesPerTypeController controller = new ListExpensesPerTypeController();

    protected ListExpensesPerTypeController getController() {
        return controller;
    }

    @Override
    public String headline() {
        return "LIST EXPENSES PER TYPE CHART";
    }
}
