/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.RegisterIncomeController;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.model.IncomeType;
import eapli.framework.presentation.SelectWidget;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class RegisterIncomeUI extends RegisterMovementBaseUI {

    @Override
    protected BaseController controller() {
        return controller;
    }
    RegisterIncomeController controller = new RegisterIncomeController();
    SelectWidget widget;

    @Override
    public boolean doShow() {
        readGeneralData();

        IncomeType incomeType = readIncomeType();

        controller.registerIncome(what, date, amount, incomeType);

        System.out.println("\nIncome recorded!");

        return true;
    }

    IncomeType readIncomeType() {
        System.out.println("-- INCOME TYPES --");
        List<IncomeType> listIncomeTypes = controller.getIncomeTypes();
        widget = new SelectWidget(listIncomeTypes, new IncomeTypeListVisitor());
        int option = widget.selectedOption();

        return listIncomeTypes.get(option - 1);
    }

    @Override
    public String headline() {
        return "REGISTER AN INCOME";
    }
}
