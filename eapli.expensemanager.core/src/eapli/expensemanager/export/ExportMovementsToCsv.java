/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import eapli.framework.visitor.Visitor;
import java.io.Writer;

/**
 * 
 * @author Fernando
 */
class ExportMovementsToCsv extends MovementsExporterBase {

	private static final String HEADING = "kind, date, amount, description, type, payment mean\n";
	private static final String CSV_EXTENSION = ".csv";

	@Override
	protected String fileExtension() {
		return CSV_EXTENSION;
	}

	@Override
	protected String header() {
		return HEADING;
	}

	@Override
	protected String footer() {
		throw new IllegalStateException();
	}

	@Override
	protected Visitor<Expense> expenseVisitor(Writer writer) {
		return new ExpenseExporterToCsvVisitor(writer);
	}

	@Override
	protected boolean hasHeader() {
		return true;
	}

	@Override
	protected boolean hasFooter() {
		return false;
	}

	@Override
	protected Visitor<Income> incomeVisitor(Writer writer) {
		return new IncomeExporterToCsvVisitor(writer);
	}

	@Override
	protected String expensesEnd() {
		return null;
	}

	@Override
	protected boolean hasExpensesEnd() {
		return false;
	}

	@Override
	protected String expensesStart() {
		throw new IllegalStateException();
	}

	@Override
	protected boolean hasExpensesStart() {
		return false;
	}

	@Override
	protected String incomesEnd() {
		throw new IllegalStateException();
	}

	@Override
	protected String incomesStart() {
		throw new IllegalStateException();
	}

	@Override
	protected boolean hasIncomesEnd() {
		return false;
	}

	@Override
	protected boolean hasIncomesStart() {
		return false;
	}
}
