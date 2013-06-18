/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.framework.persistence.jpa.JpaRepository;
import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class IncomeTypeRepositoryImpl extends JpaRepository<IncomeType, String>
        implements IncomeTypeRepository {

    @Override
    public IncomeType findById(String shortDescription) {
        return super.read(shortDescription);
    }
}
