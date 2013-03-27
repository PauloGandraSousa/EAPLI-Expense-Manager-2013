/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.IncomeType;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface IncomeTypeRepository {
        void save(IncomeType incomeType);

    public List<IncomeType> all();

}
