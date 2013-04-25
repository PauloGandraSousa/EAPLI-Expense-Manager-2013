/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.framework.BaseUI;
import eapli.expensemanager.controllers.RegisterIncomeController;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.model.IncomeType;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class RegisterIncomeUI extends BaseUI {

    @Override
    protected BaseController controller() {
        return controller;
    }
    RegisterIncomeController controller = new RegisterIncomeController();

    @Override
    public boolean doShow() {
        // TODO remove duplicate code with RegisterExpenseUI
        String what = Console.readLine("What:");
        Date date = Console.readDate("When (dd-MM-yyyy):");
        double value = Console.readDouble("How much:");
        BigDecimal amount = new BigDecimal(value);

        System.out.println("-- INCOME TYPES --");    
        // TODO remove duplicated code block also present in ListIncomeTypesUI
        int position = 1;
        List<IncomeType> listIncomeTypes = controller.getIncomeTypes();
        for (IncomeType et : listIncomeTypes) {
            System.out.println(position + ". " + et.getDescription());
            position++;
        }
        int option = Console.readOption(1, position, 0);

        //NMB: corrigida a questão do index das receitas que não permitia obter 
        // o primeiro tipo de receita
        controller.registerIncome(what, date, amount, listIncomeTypes.get(option-1));

        System.out.println("\nIncome recorded!");

        return true;
    }

    @Override
    public String headline() {
        return "REGISTER AN INCOME";
    }
}
