/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import eapli.framework.Visitor;

/**
 *
 * @author Paulo Gandra Sousa
 */
class IncomeListVisitor implements Visitor<Income> {

    public IncomeListVisitor() {
    }

    @Override
    public void visit(Income visited) {
            System.out.print(visited.getDateOcurred() + " ");
            System.out.print(visited.getAmount() + " ");
            System.out.println(visited.getDescription());
    }
    
}
