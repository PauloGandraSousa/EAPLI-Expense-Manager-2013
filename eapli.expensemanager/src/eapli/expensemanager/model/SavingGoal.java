/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.math.MathContext;
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
public class SavingGoal implements Serializable
{

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ocurred = new Date();
    /**
     * modified AJS
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Movement> listSaving = new ArrayList();
    private String goal;
    private BigDecimal goalammount;
    private BigDecimal actualsavings;

    public SavingGoal()
    {
    }

    public SavingGoal(String desctarget, BigDecimal goalammount, BigDecimal actualsavings, Date ocurred)
    {
        goal = desctarget;
        this.goalammount = goalammount;
        this.actualsavings = actualsavings;
        this.ocurred = ocurred;
    }

    public SavingGoal(String goal, BigDecimal goalammount)
    {
        this.goal = goal;
        this.goalammount = goalammount;
    }

    public boolean registerSavingWithdraw(SavingWithdraw saving)
    {
        //return 1 if bigger
        if (saving.getAmount().compareTo(actualsavings) == 1)
        {
            return false;
        }

        listSaving.add(saving);
        actualsavings.subtract(saving.getAmount());
        return true;

    }

    public void registerSavingDeposit(SavingDeposit saving)
    {
        listSaving.add(saving);
        actualsavings.add(saving.getAmount());
    }

    @Override
    public String toString()
    {
        String str = goal + goalammount.setScale(2) + getActualsavings().setScale(2) + ocurred;
        return str;
    }

    /**
     * @return the actualsavings
     */
    public BigDecimal getActualsavings()
    {
        return actualsavings;
    }
}
