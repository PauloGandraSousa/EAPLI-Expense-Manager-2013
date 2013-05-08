/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.observer;

import eapli.expensemanager.persistence.AlertLimitRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import javax.persistence.Entity;

/**
 *
 * @author mcn
 */
// TODO for consistency purposes shouldn't this class be an Active Record?
@Entity
public class AlertLimitPercentValues extends AlertLimit {

      private double percentLimitYellow;
      private double percentLimitRed;

      public AlertLimitPercentValues() {
      }

      public AlertLimitPercentValues(AlertLimitType alertType, double percentLimitYellow, double percentLimitRed) {
            super(alertType);
            this.percentLimitYellow = percentLimitYellow;
            this.percentLimitRed = percentLimitRed;
      }

      public void setPercentLimitYellow(double percentLimitYellow) {
            this.percentLimitYellow = percentLimitYellow;
      }

      public void setPercentLimitRed(double percentLimitRed) {
            this.percentLimitRed = percentLimitRed;
      }

      @Override
      public String toString() {
            String str = super.toString()
                    + "\nYellow Limit:" + percentLimitYellow + "%" + "\nRed Limit:" + percentLimitRed + "%";
            return str;
      }

      public void update(double yellow, double red) {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.update(id, yellow, red);
      }
}
