/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.ListExpensesPerTypeController;
import eapli.expensemanager.presentation.*;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
class ListExpensesUIPerTypeChart extends ListExpensesUI {

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

    /**
     * Lists all expense movements grouped by their type but it does not display
     * types with no movements
     *
     * @return
     */
    //TODO: NMB: pretende-se mostrar também tipos que não tenham movimentos?
    @Override
    public boolean doShow() {
        throw new NotImplementedException();
    }

    @Override
    public String headline() {
        return "LIST EXPENSES PER TYPE CHART";
    }

    /**
     * Permite efectuar a conversão de um valor para outra escala
     *
     * @param oldMin - exemplo 0
     * @param oldMax - exemplo 100
     * @param newMin - exemplo 0
     * @param newMax - exemplo 10
     * @param oldValue - exemplo 50
     * @return retorna o novo valor aplicando uma conversão linear - exemplo 5
     */
    //TODO: NMB: cria-se uma classe para operações matemáticas?
    public float simpleLinearConversion(float oldMin, float oldMax, float newMin, float newMax, float oldValue) {
        float new_value;
        new_value = ((oldValue - oldMin) / (oldMax - oldMin)) * (newMax - newMin) + newMin;
        return new_value;

    }

    /**
     * Permite efectuar a conversão de um valor para outra escala
     *
     * @param oldMin - exemplo 0
     * @param oldMax - exemplo 100
     * @param newMin - exemplo 0
     * @param newMax - exemplo 10
     * @param oldValue - exemplo 50
     * @return retorna o novo valor aplicando uma conversão linear - exemplo 5
     */
    public BigDecimal simpleLinearConversion(BigDecimal oldMin, BigDecimal oldMax, BigDecimal newMin, BigDecimal newMax, BigDecimal oldValue) {
        BigDecimal new_value;
        new_value = ((oldValue.subtract(oldMin)).divide(oldMax.subtract(oldMin), 1, RoundingMode.HALF_UP)).multiply((newMax.subtract(newMin)).add(newMin));
        return new_value;
    }
}
