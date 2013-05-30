package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.IOException;

import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;

public class ExpenseExporterToJsonVisitor implements Visitor<Expense> {

    private final BufferedWriter writer;

    public ExpenseExporterToJsonVisitor(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void visit(Expense visited) {
        // TODO this code is getting too much information from the expense
        // should use builder pattern

        // TODO explore the use of JAX-B for exporting the object to XML/JSON
        try {
            writer.write("{ \n");
            writer.write("occuredAt : '");
            writer.write(DateTime.format(visited.getDateOcurred()));
            writer.write("',\n");
            writer.write("amount : ");
            writer.write(Math.format(visited.getAmount()));
            writer.write(",\n");
            writer.write("description : '");
            writer.write(visited.getDescription());
            writer.write("',\n");
            writer.write("expenseType : '");
            writer.write(visited.getExpenseType().getId());
            writer.write("',\n");
            writer.write("paymentMean : '");
            writer.write(visited.getPayment().getPaymentMean().getDescription());
            writer.write("'\n}");
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
        try {
            // TODO check if we are geenrating bad formated JSON at the last element of the array
            writer.write(",\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
