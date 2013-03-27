/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.Income;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface IncomeRepository {
    void save(Income income);
}
