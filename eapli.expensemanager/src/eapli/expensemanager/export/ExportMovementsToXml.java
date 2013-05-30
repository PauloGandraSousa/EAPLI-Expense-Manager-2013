/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.util.Files;

/**
 *
 * @author Fernando
 */
public class ExportMovementsToXml implements ExportMovementsStrategy {

    private static final String DOCUMENT_BEGIN = "<Expenses>\n";
    private static final String DOCUMENT_END = "</Expenses>\n";
    private static final String XML_EXTENSION = ".xml";

    @Override
    public void export(String filename) {
        filename = Files.ensureExtension(filename, XML_EXTENSION);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));

            CheckingAccountRepository repo = PersistenceFactory
                    .buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount theAccount = repo.theAccount();

            writer.write(DOCUMENT_BEGIN);

            ExpenseExporterToXmlVisitor visitor = new ExpenseExporterToXmlVisitor(writer);
            theAccount.accept(visitor);

            writer.write(DOCUMENT_END);
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
}
