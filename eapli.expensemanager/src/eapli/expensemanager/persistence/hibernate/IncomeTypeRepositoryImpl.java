/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.hibernate;

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
public class IncomeTypeRepositoryImpl extends HibernateRepository<IncomeType, String> implements IncomeTypeRepository {


}
