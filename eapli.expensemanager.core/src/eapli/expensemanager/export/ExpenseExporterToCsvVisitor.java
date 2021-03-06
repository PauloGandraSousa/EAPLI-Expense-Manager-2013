package eapli.expensemanager.export;

import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;
import java.io.IOException;
import java.io.Writer;

/**
 * 
 * @author Paulo Gandra Sousa
 * 
 */
class ExpenseExporterToCsvVisitor implements Visitor<Expense> {

	private final Writer writer;

	ExpenseExporterToCsvVisitor(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void visit(Expense visited) {
		// TODO this code is getting too much information from the expense
		// should use builder pattern
		try {
			writer.write("expense, ");

			// FIXME the code block is duplicated
			writer.write(DateTime.format(visited.getOccurred()));
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
