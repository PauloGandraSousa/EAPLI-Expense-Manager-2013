package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ExportMovementsController;

public class ExportMovementsToCsvUI extends BaseForm {

    private ExportMovementsController controller = new ExportMovementsController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    // FIX remove this method as it is not used and the base class defines
    // the doShow() method should be overriden
    public void run() {
        System.out.println("-- EXPORT MOVEMENTS TO CSV --");
        String csvMovements = controller.getMovementsInCsv();
        System.out.println(csvMovements);
    }

    @Override
    public boolean doShow() {
        String csvMovements = controller.getMovementsInCsv();
        System.out.println(csvMovements);

        return true;
    }

    @Override
    public String headline() {
        return "EXPORT MOVEMENTS TO CSV";
    }
}
