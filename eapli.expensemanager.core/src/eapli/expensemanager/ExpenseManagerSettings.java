/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Gandra Sousa
 */
public final class ExpenseManagerSettings {

    private static Properties applicationProperties = new Properties();
    private static ExpenseManagerSettings instance;

    public static ExpenseManagerSettings instance() {
        if (instance == null) {
            instance = new ExpenseManagerSettings();
        }
        return instance;
    }

    private ExpenseManagerSettings() {
        loadProperties();
    }

    public Properties getApplicationProperties() {
        return applicationProperties;
    }
    private final static String PROPERTIES_FILENAME = "./src/eapli/expensemanager/expensemanager.properties";

    private void loadProperties() {
        InputStream propertiesStream = null;
        try {
            // TODO should use getResurceAsStream() instead of file system
            // propertiesStream = ExpenseManagerSettings.class.getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
            // if (propertiesStream == null) {
            //    throw new FileNotFoundException("property file '" + PROPERTIES_FILENAME + "' not found in the classpath");
            // }
            propertiesStream = new FileInputStream(PROPERTIES_FILENAME);
            applicationProperties.load(propertiesStream);

            //load a properties file from class path, inside static method
//            ClassLoader loader = ExpenseManagerSettings.class.getClassLoader();
//            if (loader == null) {
//                ClassLoader.getSystemClassLoader();
//            }
//            prop.load(loader.getResourceAsStream("/src/eapli/expensemanager/expensemanager.properties"));

        } catch (IOException exio) {
            setDefaultProperties();

            Logger.getLogger(ExpenseManagerSettings.class.getName()).
                    log(Level.SEVERE, null, exio);
        } finally {
            if (propertiesStream != null) {
                try {
                    propertiesStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExpenseManagerSettings.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setDefaultProperties() {
        applicationProperties.setProperty("persistence.repositoryFactory",
                                          "eapli.expensemanager.persistence.jpa.JpaRepositoryFactory");
    }
}
