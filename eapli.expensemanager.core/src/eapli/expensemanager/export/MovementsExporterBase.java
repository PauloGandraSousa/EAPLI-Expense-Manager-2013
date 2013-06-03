/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.framework.visitor.Visitor;
import eapli.util.Files;

/**
 * 
 * @author Paulo Gandra Sousa
 */
abstract class MovementsExporterBase implements ExportMovementsStrategy {

	protected abstract String fileExtension();

	protected abstract boolean hasHeader();

	protected abstract boolean hasFooter();

	protected abstract String header();

	protected abstract String footer();

	protected abstract Visitor<Expense> expenseVisitor(Writer writer);

	protected abstract Visitor<Income> incomeVisitor(Writer writer);

	protected abstract String expensesEnd();

	protected abstract boolean hasExpensesEnd();

	protected abstract String expensesStart();

	protected abstract boolean hasExpensesStart();

	protected abstract String incomesEnd();

	protected abstract String incomesStart();

	protected abstract boolean hasIncomesEnd();

	protected abstract boolean hasIncomesStart();

	/**
	 * Exports the expenses and incomes to the designated file.
	 * 
	 * follows Template Method pattern
	 * 
	 * @param filename
	 *            the name of the file to create
	 */
	@Override
	public void export(String filename) {
		filename = Files.ensureExtension(filename, fileExtension());
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename));

			CheckingAccountRepository repo = PersistenceFactory
					.buildPersistenceFactory().checkingAccountRepository();
			CheckingAccount theAccount = repo.theAccount();

			writeHeader(writer);
			writeIncomes(writer, theAccount);
			writeExpenses(writer, theAccount);
			writeFooter(writer);
		} catch (IOException e) {
			// FIXME don't silence the exception
		} catch (RuntimeException e) {
			if (e.getCause().getClass() == IOException.class) {
				// FIXME don't silence the exception
			} else {
				throw e;
			}
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// FIXME don't silence the exception
			}
		}
	}

	/**
	 * @param writer
	 * @throws IOException
	 */
	private void writeFooter(Writer writer) throws IOException {
		if (hasFooter()) {
			writer.write(footer());
		}
	}

	/**
	 * @param writer
	 * @throws IOException
	 */
	private void writeHeader(Writer writer) throws IOException {
		if (hasHeader()) {
			writer.write(header());
		}
	}

	/**
	 * @param writer
	 * @param theAccount
	 * @throws IOException
	 */
	private void writeExpenses(Writer writer, CheckingAccount theAccount)
			throws IOException {
		if (hasExpensesStart()) {
			writer.write(expensesStart());
		}
		visitExpenses(theAccount, expenseVisitor(writer));
		if (hasExpensesEnd()) {
			writer.write(expensesEnd());
		}
	}

	/**
	 * @param writer
	 * @param theAccount
	 * @throws IOException
	 */
	private void writeIncomes(Writer writer, CheckingAccount theAccount)
			throws IOException {
		if (hasIncomesStart()) {
			writer.write(incomesStart());
		}
		visitIncomes(theAccount, incomeVisitor(writer));
		if (hasIncomesEnd()) {
			writer.write(incomesEnd());
		}
	}

	private void visitExpenses(CheckingAccount theAccount,
			Visitor<Expense> visitor) {
		for (Expense anExpense : theAccount.getExpenses()) {
			visitor.beforeVisiting(anExpense);
			visitor.visit(anExpense);
			visitor.afterVisiting(anExpense);
		}
	}

	private void visitIncomes(CheckingAccount theAccount,
			Visitor<Income> visitor) {
		for (Income anIncome : theAccount.getIncomes()) {
			visitor.beforeVisiting(anIncome);
			visitor.visit(anIncome);
			visitor.afterVisiting(anIncome);
		}
	}
}
