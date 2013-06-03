/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.IncomeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class IncomeRepositoryImpl implements IncomeRepository {

    static List<Income> incomes = new ArrayList<Income>();
    
    @Override
    public Income save(Income income) {
        // TODO check if we alreay know this object or add it if not
        incomes.add(income);
        return income;
    }
    
    @Override
    public List<Income> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
