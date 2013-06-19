/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.visitors;

import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseListVisitor implements Visitor<Expense> {

    @Override
    public void visit(Expense visited) {
        System.out.print(DateTime.format(visited.getOcurred()) + " ");
        System.out.print(visited.getAmount() + " ");
        System.out.println(visited.getDescription());
    }

    @Override
    public void beforeVisiting(Expense visited) {
        // nothing to do
    }

    @Override
    public void afterVisiting(Expense visited) {
        // nothing to do
    }
}
