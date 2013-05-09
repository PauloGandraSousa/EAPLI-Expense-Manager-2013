/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.expensemanager.persistence.IncomeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ExportMovementsController extends BaseController {
    
    public String getMovementsInXml() {
        List<Movement> listMovements = getMovements();
        String xml = "<movements>";
        for (int i = 0; i < listMovements.size(); i++) {
            xml += listMovements.get(i).toXml() + "\n";
        }
        xml += "</movements>";
        return xml;
    }
    
    public String getMovementsInCsv() {
        List<Movement> listMovements = getMovements();
        String csv = "";
        for (int i = 0; i < listMovements.size(); i++) {
            csv += listMovements.get(i).toCsv() + "\n";
        }
        return csv;
    }
    
    public List<Movement> getMovements() {
        ExpenseRepository repo = PersistenceFactory.
                buildPersistenceFactory().expenseRepository();
        List<Expense> listExpenses = repo.all();
        IncomeRepository repo2 = PersistenceFactory.
                buildPersistenceFactory().incomeRepository();
//        List<Income> listIncomes = repo2.all();
        List<Movement> newList = new ArrayList<Movement>(listExpenses);
//        newList.addAll(listIncomes);
        return newList;
    }
    
}
