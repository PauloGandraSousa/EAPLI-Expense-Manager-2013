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
class ExportMovementsToXml extends MovementsExporterBase {

    private static final String DOCUMENT_BEGIN = "<Expenses>\n";
    private static final String DOCUMENT_END = "</Expenses>\n";
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
    protected Visitor<Expense> visitor(Writer writer) {
        return new ExpenseExporterToXmlVisitor(writer);
    }
}
