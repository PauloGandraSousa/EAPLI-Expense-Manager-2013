package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.IOException;

import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;

public class ExpenseExporterToCsvVisitor implements Visitor<Expense> {

    private final BufferedWriter writer;

    public ExpenseExporterToCsvVisitor(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void visit(Expense visited) {
        // TODO this code is getting too much information from the expense
        // should use builder pattern
        try {
            writer.write(DateTime.format(visited.getDateOcurred()));
            writer.write(",");
            writer.write(Math.format(visited.getAmount()));
            writer.write(",");
            writer.write(visited.getDescription());
            writer.write(",");
            writer.write(visited.getExpenseType().getId());
            writer.write(",");
            writer.write(visited.getPayment().getPaymentMean().getDescription());
            writer.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
