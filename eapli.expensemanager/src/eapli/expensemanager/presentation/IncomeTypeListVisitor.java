/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.IncomeType;
import eapli.framework.Visitor;

/**
 * an implementation of the Visitor pattern for listing objects of type ExpenseType
 * 
 * @author Paulo Gandra Sousa
 */
public class IncomeTypeListVisitor implements Visitor<IncomeType>{

    @Override
    public void visit(IncomeType visited) {
        System.out.println(visited.getDescription());
    }
    
}
