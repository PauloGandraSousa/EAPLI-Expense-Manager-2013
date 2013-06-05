/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager;

import java.io.FileNotFoundException;
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
    //private final static String PROPERTIES_FILENAME = "./res/eapli/expensemanager/expensemanager.properties";
    private final static String PROPERTIES_RESOURCE = "eapli/expensemanager/expensemanager.properties";

    private void loadProperties() {
        InputStream propertiesStream = null;
        try {
            //propertiesStream = new FileInputStream(PROPERTIES_FILENAME);
            propertiesStream = ExpenseManagerSettings.class.getClassLoader()
                    .getResourceAsStream(PROPERTIES_RESOURCE);
            if (propertiesStream != null) {
                applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException("property file '"
                        + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (IOException exio) {
            setDefaultProperties();

            Logger.getLogger(ExpenseManagerSettings.class.getName()).log(
                    Level.SEVERE, null, exio);
        } finally {
            if (propertiesStream != null) {
                try {
                    propertiesStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExpenseManagerSettings.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setDefaultProperties() {
        applicationProperties.setProperty("persistence.repositoryFactory",
                                          "eapli.expensemanager.persistence.jpa.JpaRepositoryFactory");
    }
}
