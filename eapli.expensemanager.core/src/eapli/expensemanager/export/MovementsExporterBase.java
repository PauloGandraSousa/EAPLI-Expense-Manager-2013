/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.Income;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.framework.visitor.Visitor;
import eapli.util.Files;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * the base class for exporting movements o different formats.
 *
 * application of factory method and tmeplate method patterns
 *
 * @author Paulo Gandra Sousa
 */
abstract class MovementsExporterBase implements MovementsExporter {

    /*
     * provide the file name extension for a specific format.
     */
    protected abstract String fileExtension();

    /*
     * indicates if the format has an header
     */
    protected abstract boolean hasHeader();

    /*
     * indicae sf the format has a footer
     */
    protected abstract boolean hasFooter();

    /*
     * provides the header of the export document
     */
    protected abstract String header();

    /*
     * provides the footer of the export document.
     */
    protected abstract String footer();

    /*
     * provides the actual visitor to Expense movements
     */
    protected abstract Visitor<Expense> expenseVisitor(Writer writer);

    /*
     * provides the actual visitor to Income movemnts
     */
    protected abstract Visitor<Income> incomeVisitor(Writer writer);

    /*
     * provides the end element of each Expense
     */
    protected abstract String expensesEnd();

    /*
     * indicates if the format has elements for signaling the end of an expense
     */
    protected abstract boolean hasExpensesEnd();

    /*
     * provides the start element of each Expense
     */
    protected abstract String expensesStart();

    /*
     * indicates if the format has elements for signaling the start of an expense
     */
    protected abstract boolean hasExpensesStart();

    /*
     * provides the end element of each Income
     */
    protected abstract String incomesEnd();

    /*
     * provides the start element of each Income
     */
    protected abstract String incomesStart();

    /*
     * indicates if the format has elements for signaling the end of an income
     */
    protected abstract boolean hasIncomesEnd();

    /*
     * indicates if the format has elements for signaling the start of an income
     */
    protected abstract boolean hasIncomesStart();

    /**
     * Exports the expenses and incomes to the designated file.
     *
     * follows Template Method pattern
     *
     * @param filename the name of the file to create
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
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            if (e.getCause().getClass() == IOException.class) {
                throw new RuntimeException(e);
            } else {
                throw e;
            }
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
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
