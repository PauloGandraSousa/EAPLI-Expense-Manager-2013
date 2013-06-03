/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.Writer;

import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import eapli.framework.visitor.Visitor;

/**
 * 
 * @author Fernando
 */
class ExportMovementsToJson extends MovementsExporterBase {

	private static final String DOCUMENT_BEGIN = "{\n\n";
	private static final String DOCUMENT_END = "\n}\n";
	private static final String EXPENSES_BEGIN = "expenses : [\n";
	private static final String EXPENSES_END = "]\n";
	private static final String INCOMES_BEGIN = "incomes : [\n";
	private static final String INCOMES_END = "]\n";
	private static final String JSON_EXTENSION = ".json";

	@Override
	protected String fileExtension() {
		return JSON_EXTENSION;
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
		return new ExpenseExporterToJsonVisitor(writer);
	}

	@Override
	protected Visitor<Income> incomeVisitor(Writer writer) {
		return new IncomeExporterToJsonVisitor(writer);
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
