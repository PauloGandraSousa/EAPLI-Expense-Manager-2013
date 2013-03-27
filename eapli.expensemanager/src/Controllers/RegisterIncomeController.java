/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Persistence.IncomeRepository;
import Model.Income;
import Persistence.PersistenceRegistry;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterIncomeController extends BaseController {

    public void registerIncome(String what, Date date, BigDecimal amount) {
        Income income = new Income(what, date, amount);
        IncomeRepository repo = PersistenceRegistry.instance().incomeRepository();
        repo.save(income);
    }
    
}
