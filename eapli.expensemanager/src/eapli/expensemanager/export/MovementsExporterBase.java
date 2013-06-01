/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.framework.visitor.Visitor;
import eapli.util.Files;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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

    protected abstract Visitor<Expense> visitor(Writer writer);

    @Override
    public void export(String filename) {
        filename = Files.ensureExtension(filename, fileExtension());
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));

            if (hasHeader()) {
                writer.write(header());
            }

            CheckingAccountRepository repo = PersistenceFactory.
                    buildPersistenceFactory().
                    checkingAccountRepository();
            CheckingAccount theAccount = repo.theAccount();

            theAccount.accept(visitor(writer));

            if (hasFooter()) {
                writer.write(footer());
            }
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
