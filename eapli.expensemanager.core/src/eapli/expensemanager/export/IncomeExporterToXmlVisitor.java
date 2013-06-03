package eapli.expensemanager.export;

import java.io.IOException;
import java.io.Writer;

import eapli.expensemanager.model.Income;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;

class IncomeExporterToXmlVisitor implements Visitor<Income> {

	private final Writer writer;

	public IncomeExporterToXmlVisitor(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void visit(Income visited) {
		// TODO this code is getting too much information from the expense
		// should use builder pattern

		// TODO explore the use of JAX-B for exporting the object to XML/JSON
		try {
			writer.write("<Income>\n");
			// FIXME the following code block is duplicated with ExpenseExporter
			writer.write("<OccuredAt>");
			writer.write(DateTime.format(visited.getDateOcurred()));
			writer.write("</OccuredAt>\n");
			writer.write("<Amount>");
			writer.write(Math.format(visited.getAmount()));
			writer.write("</Amount>\n");
			writer.write("<Description>");
			writer.write(visited.getDescription());
			writer.write("</Description>\n");

			writer.write("<IncomeType>");
			writer.write(visited.getIncomeType().getId());
			writer.write("</IncomeType>\n");
			writer.write("</Income>\n");
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
