/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import java.util.List;

import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;

/**
 * 
 * @author Fernando
 */
public class ExportMovementsController extends BaseController {

	public String getMovementsInXml() {
		List<Movement> listMovements = getMovements();
		// FIX the logic of creating he XML representaton of the movements
		// shouldn't
		// be in the controller.
		// FIX CSV/XML export : consider using the builder and visitor pattern
		// together with a strategy
		String xml = "<movements>";
		for (int i = 0; i < listMovements.size(); i++) {
			// FIX dont use += with strings specially in a for loop
			xml += listMovements.get(i).toXml() + "\n";
		}
		xml += "</movements>";
		return xml;
	}

	public String getMovementsInCsv() {
		List<Movement> listMovements = getMovements();
		// FIX the logic of creating the CSV representation of the movements
		// shouldn't
		// be in the controller.
		// FIX CSV/XML export : consider using the builder and visitor pattern
		// together with a strategy
		String csv = "";
		for (int i = 0; i < listMovements.size(); i++) {
			// FIX don't use += with strings specially in a for loop
			csv += listMovements.get(i).toCsv() + "\n";
		}
		return csv;
	}

	public List<Movement> getMovements() {
		CheckingAccountRepository repo = PersistenceFactory
				.buildPersistenceFactory().checkingAccountRepository();
		return repo.theAccount().getMovements();
	}
}
