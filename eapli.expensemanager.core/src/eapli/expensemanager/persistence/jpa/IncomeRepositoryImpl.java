/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.framework.persistence.JpaRepository;
import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.IncomeRepository;

/**
 * 
 * @author Paulo Gandra Sousa
 */
public class IncomeRepositoryImpl extends JpaRepository<Income, Long> implements
		IncomeRepository {

}
