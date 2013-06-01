/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

/**
 *
 * @author Fernando
 */
public class ExportMovementsFactory {

    private static ExportMovementsFactory instance = new ExportMovementsFactory();

    private ExportMovementsFactory() {
    }

    public static ExportMovementsFactory getInstance() {
        return instance;
    }

    public ExportMovementsStrategy getExporter(int format) {
        switch (format) {
            case ExportMovementsStrategy.CSV:
                return new ExportMovementsToCsv();

            case ExportMovementsStrategy.XML:
                return new ExportMovementsToXml();

            case ExportMovementsStrategy.JSON:
                return new ExportMovementsToJson();

            default:
                return null;
        }
    }
}
