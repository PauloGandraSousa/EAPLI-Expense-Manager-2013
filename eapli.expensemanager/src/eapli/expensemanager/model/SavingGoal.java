/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author losa
 */
@Entity
public class SavingGoal implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    
    // TODO what is he purpose of this field? the expected date of conclusion for the goal?
    // if so, the name should be more explicit
    private Date ocurred = new Date();
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Movement> savings = new ArrayList();
    private String goal;
    private BigDecimal targetAmount;
    private BigDecimal actualSavings;

    public SavingGoal() {
    }

    // TODO what is the meaning of creating a goal with already an "actual savings" amount?
    public SavingGoal(String targetDescription, BigDecimal targetAmount, BigDecimal actualsavings, Date ocurred) {
        goal = targetDescription;
        this.targetAmount = targetAmount;
        this.actualSavings = actualsavings;
        this.ocurred = ocurred;
    }

    public SavingGoal(String goal, BigDecimal targetAmount) {
        this.goal = goal;
        this.targetAmount = targetAmount;
    }

    public boolean registerSavingWithdraw(SavingWithdraw saving) {
        //return 1 if bigger
        if (saving.getAmount().compareTo(actualSavings) == 1) {
            // TODO should throw a busines exception instead of return true/false
            return false;
        }

        savings.add(saving);
        actualSavings = actualSavings.subtract(saving.getAmount());
        return true;
    }

    public void registerSavingDeposit(SavingDeposit saving) {
        savings.add(saving);
        actualSavings = actualSavings.add(saving.getAmount());
    }

    @Override
    public String toString() {
        String str = goal + targetAmount.setScale(2) + getActualSavings().setScale(2) + ocurred;
        return str;
    }

    
    //ajs p/ o visitor
    public String getDescription() 
    {
        String str = goal + " Target Amount:" + targetAmount.setScale(2) + " Actual Savings:" + getActualSavings().setScale(2);
        return str;
    }
    
    
    /**
     * @return the actualSavings
     */
    public BigDecimal getActualSavings() {
        return actualSavings;
    }

    // TODO what is the purpose of this method on the public API of the class?
    private boolean enoughSavings(BigDecimal amount) {
        // return 1 if bigger
        if (amount.compareTo(actualSavings) == 1) {
            return false;
        }

        return true;
    }
    
    /**
     * check if we already have the desired target amount
     * 
     * @return 
     */
    public boolean isGoalFulfiled() {
        return  actualSavings.compareTo(targetAmount) >= 0 ;
    }
}
