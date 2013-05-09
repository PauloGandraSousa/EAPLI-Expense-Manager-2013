/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.SavingGoal;
import eapli.framework.Visitor;

/**
 *
 * @author AJS
 */
public class SavingGoalVisitor implements Visitor<SavingGoal>{

    @Override
    public void visit(SavingGoal visited) 
    {
        System.out.println(visited.getDescription());
    }
    
}