/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager;

import eapli.expensemanager.bootstrap.ReferenceDataBootstrap;
import eapli.expensemanager.bootstrap.SomeDefaultAlertLimitBootstrap;
import eapli.expensemanager.bootstrap.SomeExpensesBootstrap;
import eapli.expensemanager.bootstrap.SomeIncomesBootstrap;
import eapli.expensemanager.presentation.MainMenu;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Gandra Sousa
 */
public final class ExpenseManager {

    private ExpenseManager() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadProperties();

        // call the bootstraper
        // the next line should be removed for "production" ready deployment
        doBootstrap();

        final MainMenu menu = new MainMenu();
        menu.mainLoop();
    }
    private static Properties applicationProperties = new Properties();

    public static Properties getApplicationProperties() {
        return applicationProperties;
    }

    private static void loadProperties() {
        FileInputStream propertiesStream = null;
        try {
            propertiesStream = new FileInputStream("./src/eapli/expensemanager/expensemanager.properties");
            applicationProperties.load(propertiesStream);

            //load a properties file from class path, inside static method
//            ClassLoader loader = ExpenseManager.class.getClassLoader();
//            if (loader == null) {
//                ClassLoader.getSystemClassLoader();
//            }
//            prop.load(loader.getResourceAsStream("/src/eapli/expensemanager/expensemanager.properties"));

        } catch (IOException ex) {
            //default values
            applicationProperties.setProperty("persistence.repositoryFactory",
                    "eapli.expensemanager.persistence.JpaRepositoryFactory");

            Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (propertiesStream != null) {
                try {
                    propertiesStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExpenseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static void doBootstrap() {
        new ReferenceDataBootstrap().bootstrap();

        new SomeIncomesBootstrap().bootstrap();

        new SomeExpensesBootstrap().bootstrap();

        new SomeDefaultAlertLimitBootstrap().bootstrap();
    }
}
