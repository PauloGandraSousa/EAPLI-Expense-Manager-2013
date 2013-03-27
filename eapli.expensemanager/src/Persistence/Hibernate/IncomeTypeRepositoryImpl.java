/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Hibernate;

import Model.IncomeType;
import Persistence.IncomeTypeRepository;
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
