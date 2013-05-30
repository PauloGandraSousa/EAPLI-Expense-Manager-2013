package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ExportMovementsController;
import eapli.expensemanager.export.ExportMovementsStrategy;
import eapli.util.Console;

public class ExportMovementsUI extends BaseUI {

	private final ExportMovementsController controller = new ExportMovementsController();

	@Override
	protected BaseController getController() {
		return controller;
	}

	@Override
	public boolean doShow() {
		String filename = Console
				.readLine("Introduza o nome do ficheiro a criar:");

		System.out.println("1. CSV");
		System.out.println("2. XML");
		System.out.println("0. Exit");
		int option = Console.readOption(1, 2, 0);
		switch (option) {
		case 1:
			controller.export(ExportMovementsStrategy.CSV, filename);
			break;
		case 2:
			controller.export(ExportMovementsStrategy.XML, filename);
			break;
		}

		return true;
	}

	@Override
	public String headline() {
		return "EXPORT MOVEMENTS";
	}
}
