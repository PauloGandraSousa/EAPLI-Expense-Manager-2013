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
class ExportMovementsToXml extends MovementsExporterBase {

	private static final String DOCUMENT_BEGIN = "<Movements>\n";
	private static final String DOCUMENT_END = "</Movements>\n";
	private static final String EXPENSES_BEGIN = "<Expenses>\n";
	private static final String EXPENSES_END = "</Expenses>\n";
	private static final String INCOMES_BEGIN = "<Incomes>\n";
	private static final String INCOMES_END = "</Incomes>\n";
	private static final String XML_EXTENSION = ".xml";

	@Override
	protected String fileExtension() {
		return XML_EXTENSION;
	}

	@Override
	protected boolean hasHeader() {
		return true;
	}

	@Override
	protected boolean hasFooter() {
		return true;
	}

	@Override
	protected String header() {
		return DOCUMENT_BEGIN;
	}

	@Override
	protected String footer() {
		return DOCUMENT_END;
	}

	@Override
	protected Visitor<Expense> expenseVisitor(Writer writer) {
		return new ExpenseExporterToXmlVisitor(writer);
	}

	@Override
	protected Visitor<Income> incomeVisitor(Writer writer) {
		return new IncomeExporterToXmlVisitor(writer);
	}

	@Override
	protected String expensesEnd() {
		return EXPENSES_END;
	}

	@Override
	protected boolean hasExpensesEnd() {
		return true;
	}

	@Override
	protected String expensesStart() {
		return EXPENSES_BEGIN;
	}

	@Override
	protected boolean hasExpensesStart() {
		return true;
	}

	@Override
	protected String incomesEnd() {
		return INCOMES_END;
	}

	@Override
	protected String incomesStart() {
		return INCOMES_BEGIN;
	}

	@Override
	protected boolean hasIncomesEnd() {
		return true;
	}

	@Override
	protected boolean hasIncomesStart() {
		return true;
	}
}
