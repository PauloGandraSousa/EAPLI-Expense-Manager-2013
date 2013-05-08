/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model.observer;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.persistence.ActiveRecord;
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
public class AlertLimitByExpenseType extends AlertLimitPercentValues implements ActiveRecord {
      @OneToOne
      private ExpenseType expenseType;

      public AlertLimitByExpenseType() {
      }


       public AlertLimitByExpenseType(AlertLimitType alertType, double limitYellow, double limitRed,ExpenseType eT) {
            super(alertType, limitYellow, limitRed);
            this.expenseType=eT;
      }

      public ExpenseType getExpenseType() {
            return expenseType;
      }
        
         public static AlertLimitByExpenseType findByExpenseType(ExpenseType eT) {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            List<AlertLimitByExpenseType> list=repo.findByET(eT);
            if(list.isEmpty()){
                  return null;
            }
            return list.get(0);
      }
         
           @Override
      public String toString() {
             String str =super.toString()+ "\nExpenseType:"+expenseType.getDescription();
            return str;
      }
      
@Override
      public void save() {
            AlertLimitRepository repo = PersistenceFactory.buildPersistenceFactory().alertLimitRepository();
            repo.save(this);
      }

}
