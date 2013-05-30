/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.util.Files;

/**
 *
 * @author Fernando
 */
public class ExportMovementsToCsv implements ExportMovementsStrategy {

    private static final String HEADING = "date, amount, description, expense type, payment mean\n";
    private static final String CSV_EXTENSION = ".csv";

    @Override
    public void export(String filename) {
        filename = Files.ensureExtension(filename, CSV_EXTENSION);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(HEADING);

            CheckingAccountRepository repo = PersistenceFactory
                    .buildPersistenceFactory().checkingAccountRepository();
            CheckingAccount theAccount = repo.theAccount();

            ExpenseExporterToCsvVisitor visitor = new ExpenseExporterToCsvVisitor(writer);
            theAccount.accept(visitor);
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
