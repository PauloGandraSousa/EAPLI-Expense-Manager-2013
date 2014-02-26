package eapli.expensemanager.export;

import eapli.expensemanager.model.Income;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;
import java.io.IOException;
import java.io.Writer;

class IncomeExporterToJsonVisitor implements Visitor<Income> {

	private final Writer writer;

	IncomeExporterToJsonVisitor(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void visit(Income visited) {
		// TODO this code is getting too much information from the expense
		// should use builder pattern

		// TODO explore the use of JAX-B for exporting the object to XML/JSON
		try {
			writer.write("{ \n");

			// FIXME this code block is duplicated with ExpenseExporter
			writer.write("occuredAt : '");
			writer.write(DateTime.format(visited.getOccurred()));
			writer.write("',\n");
			writer.write("amount : ");
			writer.write(Math.format(visited.getAmount()));
			writer.write(",\n");
			writer.write("description : '");
			writer.write(visited.getDescription());
			writer.write("',\n");

			writer.write("incomeType : '");
			writer.write(visited.getIncomeType().getId());
			writer.write("'\n");
			writer.write("}");
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
		try {
			// TODO check if we are generating bad formated JSON at the last
			// element of the array
			writer.write(",\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
