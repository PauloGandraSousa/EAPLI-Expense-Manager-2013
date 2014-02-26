/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.IncomeRepository;
import eapli.framework.persistence.jpa.JpaRepository;

/**
 * 
 * @author Paulo Gandra Sousa
 */
public class IncomeRepositoryImpl extends JpaRepository<Income, Long> implements
		IncomeRepository {

}
