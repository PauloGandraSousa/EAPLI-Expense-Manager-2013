/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterIncomeTypeController;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class RegisterIncomeTypeUI extends RegisterMovementTypeBaseUI {
    private final RegisterIncomeTypeController controller = new RegisterIncomeTypeController();

    @Override
    public boolean doShow() {
		readGeneralData();
		
		controller.registerIncomeType(shortName, descr);
		
		System.out.println("\nIncome type recorded!");
		
		return true;
	}

    @Override
    protected BaseController getController() {
		return controller;
	}

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE TYPE";
    }
}
