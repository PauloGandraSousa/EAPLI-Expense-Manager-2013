package eapli.expensemanager.export;

import java.io.IOException;
import java.io.Writer;

import eapli.expensemanager.model.Income;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;

class IncomeExporterToCsvVisitor implements Visitor<Income> {

	private final Writer writer;

	public IncomeExporterToCsvVisitor(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void visit(Income visited) {
		// TODO this code is getting too much information from the expense
		// should use builder pattern
		try {
			writer.write("income, ");

			// FIXME this code block is duplicated with ExpenseExporter
			writer.write(DateTime.format(visited.getDateOcurred()));
			writer.write(",");
			writer.write(Math.format(visited.getAmount()));
			writer.write(",");
			writer.write(visited.getDescription());
			writer.write(",");
			writer.write(visited.getIncomeType().getId());

			writer.write(",");
			writer.write("\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void beforeVisiting(Income visited) {
		// nothing to do
	}

	@Override
	public void afterVisiting(Income visited) {
		// nothing to do
	}
}
