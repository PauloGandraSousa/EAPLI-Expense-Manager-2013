package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.IOException;

import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;
import eapli.util.DateTime;
import eapli.util.Math;

public class XmlVisitor implements Visitor<Expense> {
	private final BufferedWriter writer;

	public XmlVisitor(BufferedWriter writer) {
		this.writer = writer;
	}

	@Override
	public void visit(Expense visited) {
		try {
			writer.write("<Expense>");
			writer.write("<OccuredAt>");
			writer.write(DateTime.format(visited.getDateOcurred()));
			writer.write("</OccuredAt>");
			writer.write("<Amount>");
			writer.write(Math.format(visited.getAmount()));
			writer.write("</Amount>");
			writer.write("<Description>");
			writer.write(visited.getDescription());
			writer.write("</Description>");
			writer.write("<ExpenseType>");
			writer.write(visited.getExpenseType().getId());
			writer.write("</ExpenseType>");
			writer.write("<PaymentMean>");
			writer.write(visited.getPayment().getPaymentMean().getDescription());
			writer.write("</PaymentMean>");
			writer.write("</Expense>");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
