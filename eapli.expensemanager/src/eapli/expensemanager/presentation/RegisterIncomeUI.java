/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.visitors.IncomeTypeListVisitor;
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
    protected BaseController getController() {
        return controller;
    }
    private RegisterIncomeController controller = new RegisterIncomeController();
    private SelectWidget<IncomeType> incomeTypesSelectWidget;

    @Override
    public boolean doShow() {
        readGeneralData();

        IncomeType incomeType = readIncomeType();
        if (incomeType == null) {
            return true;
        }

        controller.registerIncome(what, date, amount, incomeType);

        System.out.println("\nIncome recorded!");

        return true;
    }

    IncomeType readIncomeType() {
        System.out.println("-- INCOME TYPES --");
        List<IncomeType> listIncomeTypes = controller.getIncomeTypes();
        incomeTypesSelectWidget = new SelectWidget<IncomeType>(listIncomeTypes, new IncomeTypeListVisitor());
        int option = incomeTypesSelectWidget.selectedOption();
        if (option == 0) {
            return null;
        }
        return listIncomeTypes.get(option - 1);
    }

    @Override
    public String headline() {
        return "REGISTER AN INCOME";
    }
}
