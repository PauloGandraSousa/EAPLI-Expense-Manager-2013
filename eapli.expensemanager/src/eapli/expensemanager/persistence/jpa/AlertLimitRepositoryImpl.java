/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.AlertLimitRepository;

/**
 *
 * @author mcn
 */
public class AlertLimitRepositoryImpl extends JpaRepository<AlertLimit, Integer> implements AlertLimitRepository {

      @Override
      public AlertLimit findByKey(int key) {
            return super.read(key);
      }

      @Override
      public AlertLimit save(AlertLimit alertLimit) {
            return super.save(alertLimit);
      }

      @Override
      public AlertLimit findByAlertType(AlertLimitType a) {
            EntityManager em = getEntityManager();
            Query q = em
                    .createQuery("SELECT e FROM AlertLimit e WHERE e.alertType = :aLertT");
            q.setParameter("aLertT", a);
            @SuppressWarnings("unchecked")
            List<AlertLimit> list = q.getResultList();
            if (list.isEmpty()) {
                  return null;
            }
            return list.get(0);
      }

      @Override
      public AlertLimit findByExpenseType(ExpenseType eT) {

            EntityManager em = getEntityManager();
            Query q = em
                    .createQuery("SELECT e FROM AlertLimitByExpenseType e WHERE e.expenseType= :eT");
            q.setParameter("eT", eT);
            @SuppressWarnings("unchecked")
            List<AlertLimit> list = q.getResultList();
            if (list.isEmpty()) {

                  return null;
            }
            return list.get(0);
      }
      
      
      @Override
      public AlertLimit updateAL(AlertLimit al){
            EntityManager em = getEntityManager();
             
            assert em != null;
            EntityTransaction tx = em.getTransaction();

            AlertLimit temp = null;
            try {
                  tx.begin();
                  // Because entity is detached
                  temp=em.merge(al);
                  if( al instanceof AlertLimitExpenditure ){  
                  ((AlertLimitExpenditure)temp).setLimitYellow(((AlertLimitExpenditure)al).getLimitYellow());
                  ((AlertLimitExpenditure)temp).setLimitRed(((AlertLimitExpenditure)al).getLimitRed());
                  }
                  else{
                         ((AlertLimitByExpenseType)temp).setPercentLimitYellow(((AlertLimitByExpenseType)al).getPercentLimitYellow());
                  ((AlertLimitByExpenseType)temp).setPercentLimitRed(((AlertLimitByExpenseType)al).getPercentLimitRed());
                  }            
                  tx.commit();
            } catch (PersistenceException ex) {
                  // FIXE 
                  throw new IllegalStateException();
            } finally {
                  em.close();
            }
            return temp;       
      }
      
}
