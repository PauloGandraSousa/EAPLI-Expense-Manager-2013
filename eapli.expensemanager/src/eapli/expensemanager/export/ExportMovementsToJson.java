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
class ExportMovementsToJson extends MovementsExporterBase {

    private static final String DOCUMENT_BEGIN = "{\nexpenses : [\n";
    private static final String DOCUMENT_END = "]\n}\n";
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
    protected Visitor<Expense> visitor(Writer writer) {
        return new ExpenseExporterToJsonVisitor(writer);
    }
}
