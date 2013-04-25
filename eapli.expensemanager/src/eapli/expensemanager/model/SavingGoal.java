/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;


import java.util.ArrayList;
import java.util.List;
import eapli.expensemanager.model.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 *
 * @author losa
 */
@Entity
public class SavingGoal {
    
    @Id
    Long id;
    @GeneratedValue
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date ocurred;   
    
    @OneToMany (cascade= CascadeType.MERGE)
    List<Saving> savings=new ArrayList<Saving>();
    
    String target;
    BigDecimal goalammount;
    BigDecimal actualsavings;        

    public SavingGoal(){}
    public SavingGoal(String desctarget, BigDecimal goalammount) {
      target=desctarget;
      this.goalammount=goalammount;
    }
}
