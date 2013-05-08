/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.observer;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author mcn
 */
@Entity
public class AlertLimitByExpenseType extends AlertLimit {

      private double percentLimitYellow;
      private double percentLimitRed;
      @OneToOne
      private ExpenseType expenseType;

      public AlertLimitByExpenseType() {
      }

      public double getPercentLimitYellow() {
            return percentLimitYellow;
      }

      public double getPercentLimitRed() {
            return percentLimitRed;
      }

      public AlertLimitByExpenseType(AlertLimitType alertType, double percentLimitYellow, double percentLimitRed, ExpenseType eT) {
            super(alertType);
            this.percentLimitYellow = percentLimitYellow;
            this.percentLimitRed = percentLimitRed;
            this.expenseType = eT;
      }

      public void setPercentLimitYellow(double percentLimitYellow) {
            this.percentLimitYellow = percentLimitYellow;
      }

      public void setPercentLimitRed(double percentLimitRed) {
            this.percentLimitRed = percentLimitRed;
      }

      public ExpenseType getExpenseType() {
            return expenseType;
      }

      @Override
      public String toString() {
            String str = super.toString()
                    + "\nYellow Limit:" + percentLimitYellow + "%" + "\nRed Limit:" + percentLimitRed + "%\nExpenseType:" + expenseType.getDescription();
            return str;
      }

      public static AlertLimitByExpenseType findByExpenseType(ExpenseType eT) {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            List<AlertLimitByExpenseType> list = repo.findByET(eT);
            if (list.isEmpty()) {
                  return null;
            }
            return list.get(0);
      }

      public void updateLimits(double yellow, double red) {
            this.percentLimitYellow=yellow;
            this.percentLimitRed=red;
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.update(this);
      }

      @Override
      public void save() {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.save(this);
      }
}
