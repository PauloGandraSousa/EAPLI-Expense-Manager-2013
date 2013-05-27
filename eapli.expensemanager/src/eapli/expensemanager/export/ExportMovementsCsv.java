/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ExportMovementsCsv  implements IExportMovementsStrategy {
  
    
    public String getOutput() {
        String csv = getMovementsInCsv();
        save(csv, "ExportMovements.csv");
        return csv;
    }

    public String getMovementsInCsv() {
        List<Movement> listMovements = getMovements();
        // An alternative would be using the builder and visitor pattern
        StringBuilder csv = new StringBuilder("");
        for (int i = 0; i < listMovements.size(); i++) {
            csv.append(listMovements.get(i).toCsv()).append("\n");
        }
        return csv.toString();
    }

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
        }
        catch (IOException e) { }
        finally {
            try {
                writer.close( );
            }
            catch(IOException e) {}
	}
    }
}
