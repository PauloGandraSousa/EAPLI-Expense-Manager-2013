/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;

/**
 * 
 * @author Paulo Gandra Sousa
 */
public class IncomeTypeRepositoryImpl extends JpaRepository<IncomeType, String>
		implements IncomeTypeRepository {

	@Override
	public IncomeType findForName(String shortDescription) {
		return super.read(shortDescription);
	}

}
