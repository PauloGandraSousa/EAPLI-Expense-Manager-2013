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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 *
 * @author losa
 */
@Entity
public class SavingGoal {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ocurred=new Date();   
    
    @OneToMany (cascade= CascadeType.ALL)    
    private List<Saving> listSaving = new ArrayList<Saving>();
    
    private String goal;
    private BigDecimal goalammount;
    private BigDecimal actualsavings;        

    public SavingGoal(){}
    public SavingGoal(String desctarget, BigDecimal goalammount, BigDecimal actualsavings, Date ocurred) 
    {
    goal=desctarget;
    this.goalammount=goalammount;
    this.actualsavings=actualsavings;
    this.ocurred = ocurred;
    }

    
    
     public Saving registerSaving(Saving saving)
    {
        listSaving.add(saving);
        return saving;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the ocurred
     */
    public Date getOcurred() {
        return ocurred;
    }

    /**
     * @param ocurred the ocurred to set
     */
    public void setOcurred(Date ocurred) {
        this.ocurred = ocurred;
    }

    /**
     * @return the target
     */
    public String getGoal() {
        return goal;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(String goal) {
        this.goal = goal;
    }

    /**
     * @return the goalammount
     */
    public BigDecimal getGoalammount() {
        return goalammount;
    }

    /**
     * @param goalammount the goalammount to set
     */
    public void setGoalammount(BigDecimal goalammount) {
        this.goalammount = goalammount;
    }

    /**
     * @return the actualsavings
     */
    public BigDecimal getActualsavings() {
        return actualsavings;
    }

    /**
     * @param actualsavings the actualsavings to set
     */
    public void setActualsavings(BigDecimal actualsavings) {
        this.actualsavings = actualsavings;
    }
    
    public String toString()
    {
        String str=goal+  goalammount.setScale(2) + actualsavings.setScale(2)+ ocurred;
        return str;
    }

    /**
     * @return the listSaving
     */
    public List<Saving> getListSaving() {
        return listSaving;
    }

    /**
     * @param listSaving the listSaving to set
     */
    public void setListSaving(List<Saving> listSaving) {
        this.listSaving = listSaving;
    }
    
    
     
     public SavingGoal(String goal, BigDecimal goalammount)     {
     this.goal=goal;this.goalammount=goalammount;
     }
     
     
}
