package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ExportMovementsController;

public class ExportMovementsToCsvUI extends BaseUI {

    private ExportMovementsController controller = new ExportMovementsController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public boolean doShow() {
        System.setProperty("ExportMovementsStrategy", "eapli.expensemanager.export.ExportMovementsCsv");
        String csvMovements = controller.getExportString();
        System.out.println(csvMovements);
        return true;
    }

    @Override
    public String headline() {
        return "EXPORT MOVEMENTS TO CSV";
    }
}
