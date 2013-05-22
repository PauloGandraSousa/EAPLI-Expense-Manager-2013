/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.ExpenseType;
import eapli.framework.visitor.Visitor;

/**
 * an implementation of the Visitor pattern for listing objects of type
 * ExpenseType
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypeListVisitor implements Visitor<ExpenseType> {

    @Override
    public void visit(ExpenseType visited) {
        System.out.println(visited.getDescription());
    }
}
