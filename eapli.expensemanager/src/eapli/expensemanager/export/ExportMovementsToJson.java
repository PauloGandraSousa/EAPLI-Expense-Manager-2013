/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.util.Files;

/**
 *
 * @author Fernando
 */
public class ExportMovementsToJson implements ExportMovementsStrategy {

    private static final String DOCUMENT_BEGIN = "{\nexpenses : [\n";
    private static final String DOCUMENT_END = "]\n}\n";
    private static final String JSON_EXTENSION = ".json";

    @Override
    public void export(String filename) {
        filename = Files.ensureExtension(filename, JSON_EXTENSION);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));

            CheckingAccountRepository repo = PersistenceFactory
                    .buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount theAccount = repo.theAccount();

            writer.write(DOCUMENT_BEGIN);

            ExpenseExporterToJsonVisitor visitor = new ExpenseExporterToJsonVisitor(writer);
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
