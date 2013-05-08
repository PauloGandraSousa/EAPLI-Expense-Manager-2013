/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class IncomeTypeRepositoryImpl extends JpaRepository<IncomeType, String> implements IncomeTypeRepository {

    @Override
    public IncomeType findForName(String shortDescription) {
        return super.read(shortDescription);
    }


}
