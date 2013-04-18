/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class IncomeTypeRepositoryImpl implements IncomeTypeRepository {

    static List<IncomeType> incomeTypes = new ArrayList<IncomeType>();
    
    @Override
    public IncomeType save(IncomeType incomeType) {
        // TODO check if we alreay know this object or add it if not
        incomeTypes.add(incomeType);
        return incomeType;
    }

    @Override
    public List<IncomeType> all() {
        return incomeTypes;
    }
    
}
