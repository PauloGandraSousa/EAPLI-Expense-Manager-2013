/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.jpa;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.AlertLimit;
import eapli.expensemanager.model.AlertLimitByExpenseType;
import eapli.expensemanager.model.AlertLimitExpenditure;
import eapli.expensemanager.model.AlertLimitType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author mcn
 */
public class AlertLimitRepositoryImpl extends JpaRepository<AlertLimit, Integer> implements AlertLimitRepository {

      @Override
      public List<AlertLimit> all() {
            return super.all();
      }

      @Override
      public AlertLimit findByKey(int key) {
            return super.read(key);
      }

      @Override
      public AlertLimitExpenditure update(AlertLimitExpenditure al) {
            EntityManager em = getEntityManager();
            assert em != null;
            EntityTransaction tx = em.getTransaction();

            AlertLimitExpenditure temp = null;
            try {
                  tx.begin();
            // TODO why are we searching for the object if we already receive it?
            temp = (AlertLimitExpenditure) em.find(entityClass, al.getId());
                  temp.setLimitYellow(al.getLimitYellow());
                  temp.setLimitRed(al.getLimitRed());
                  tx.commit();
            } catch (PersistenceException ex) {
            //FIX this is suppressing the exception it should never happen
            // either we catch and handle it or rethrow it
            } finally {
                  em.close();
            }
            return temp;
      }

      @Override
      public AlertLimitByExpenseType update(AlertLimitByExpenseType al) {
            EntityManager em = getEntityManager();
            assert em != null;
            EntityTransaction tx = em.getTransaction();

            AlertLimitByExpenseType temp = null;
            try {
                  tx.begin();
            // TODO why are we searching for the object if we already receive it?
            temp = (AlertLimitByExpenseType) em.find(entityClass, al.getId());
                  temp.setPercentLimitRed(al.getPercentLimitRed());
                  temp.setPercentLimitYellow(al.getPercentLimitYellow());
                  tx.commit();
            } catch (PersistenceException ex) {
            //FIX this is suppressing the exception it should never happen
            // either we catch and handle it or rethrow it
            } finally {
                  em.close();
            }
            return temp;
      }

      @Override
      public AlertLimit save(AlertLimit alertLimit) {
            return super.save(alertLimit);
      }

      @Override
      public AlertLimit findByAlertType(AlertLimitType a) {
            EntityManager em = getEntityManager();
            Query q = em.createQuery("SELECT e FROM AlertLimit e WHERE e.alertType = :aLertT");
            q.setParameter("aLertT", a);
            List<AlertLimit> list = q.getResultList();
            if (list.isEmpty()) {

                  return null;
            }
            return list.get(0);
      }

      @Override
      public AlertLimit findAlertLimitsByExpenseType(ExpenseType eT) {

            EntityManager em = getEntityManager();
            Query q = em.createQuery("SELECT e FROM AlertLimitByExpenseType e WHERE e.expenseType= :eT");
            q.setParameter("eT", eT);
            List<AlertLimit> list = q.getResultList();
            if (list.isEmpty()) {

                  return null;
            }
            return list.get(0);
      }


      }
