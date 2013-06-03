/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.Writer;
import eapli.expensemanager.model.Expense;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Fernando
 */
class ExportMovementsToCsv extends MovementsExporterBase {

    private static final String HEADING = "date, amount, description, expense type, payment mean\n";
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
    protected Visitor<Expense> visitor(Writer writer) {
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
}
