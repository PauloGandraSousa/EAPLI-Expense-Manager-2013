package eapli.expensemanager.export;

import java.io.Writer;
import java.io.IOException;

import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;

class ExpenseExporterToXmlVisitor implements Visitor<Expense> {

    private final Writer writer;

    public ExpenseExporterToXmlVisitor(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void visit(Expense visited) {
        // TODO this code is gettig too much information from the expense
        // should use builder pattern

        // TODO explore the use of JAX-B for exporting the object to XML/JSON
        try {
            writer.write("<Expense>\n");
            writer.write("<OccuredAt>");
            writer.write(DateTime.format(visited.getDateOcurred()));
            writer.write("</OccuredAt>\n");
            writer.write("<Amount>");
            writer.write(Math.format(visited.getAmount()));
            writer.write("</Amount>\n");
            writer.write("<Description>");
            writer.write(visited.getDescription());
            writer.write("</Description>\n");
            writer.write("<ExpenseType>");
            writer.write(visited.getExpenseType().getId());
            writer.write("</ExpenseType>\n");
            writer.write("<PaymentMean>");
            writer.write(visited.getPayment().getPaymentMean().getDescription());
            writer.write("</PaymentMean>\n");
            writer.write("</Expense>\n");
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
