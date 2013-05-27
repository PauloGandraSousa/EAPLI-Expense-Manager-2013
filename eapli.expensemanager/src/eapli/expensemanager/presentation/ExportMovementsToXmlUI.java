package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ExportMovementsController;

public class ExportMovementsToXmlUI extends BaseUI {

    private ExportMovementsController controller = new ExportMovementsController();

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    public boolean doShow() {
        System.setProperty("ExportMovementsStrategy", "eapli.expensemanager.export.ExportMovementsXml");
        String xmlMovements = controller.getExportString();
        System.out.println(xmlMovements);
        return true;
    }

    @Override
    public String headline() {
        return "EXPORT MOVEMENTS TO XML";
    }
}
