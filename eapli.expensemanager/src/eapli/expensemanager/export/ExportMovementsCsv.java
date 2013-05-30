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
public class ExportMovementsCsv implements ExportMovementsStrategy {

	private static final String HEADING = "date, amount, description, expense type, payment mean\n";
	private static final String CSV_EXTENSION = ".csv";

	@Override
	public String getOutput() {
		String csv = getMovementsInCsv();
		// FIXME this method is misleading as it is "getting" the output but as
		// a side effect it saves it to a file
		save(csv, "ExportMovements.csv");
		return csv;
	}

	public String getMovementsInCsv() {
		List<Movement> listMovements = getMovements();
		// TODO An alternative would be using the builder and visitor pattern
		StringBuilder csv = new StringBuilder("");
		for (int i = 0; i < listMovements.size(); i++) {
			csv.append(listMovements.get(i).toCsv()).append("\n");
		}
		return csv.toString();
	}

	// FIXME this code is duplicated with ExportMovementsCsv
	public List<Movement> getMovements() {
		CheckingAccountRepository repo = PersistenceFactory
				.buildPersistenceFactory().checkingAccountRepository();
		return repo.theAccount().getMovements();
	}

	public void save(String csv, String fileName) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(csv);
		} catch (IOException e) {
			// FIXME don't silence the exception
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// FIXME don't silence the exception
			}
		}
	}

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

			CsvVisitor visitor = new CsvVisitor(writer);
			theAccount.accept(visitor);
		} catch (IOException e) {
			// FIXME don't silence the exception
		} catch (RuntimeException e) {
			if (e.getCause().getClass() == IOException.class) {
				// FIXME don't silence the exception
			} else
				throw e;
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// FIXME don't silence the exception
			}
		}
	}
}
