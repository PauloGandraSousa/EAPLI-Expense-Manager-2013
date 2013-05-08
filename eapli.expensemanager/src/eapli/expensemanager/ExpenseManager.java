/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager;

import eapli.expensemanager.bootstrap.Bootstrap;
import eapli.expensemanager.bootstrap.SomeDefaultAlertLimitBootstrap;
import eapli.expensemanager.bootstrap.SomeExpensesBootstrap;
import eapli.expensemanager.bootstrap.SomeIncomesBootstrap;
import eapli.expensemanager.presentation.MainMenu;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadProperties();

        // call the bootstraper
        // the next line should be removed for "production" ready deployment
        doBootstrap();

        MainMenu menu = new MainMenu();
        menu.mainLoop();
    }

    private static Properties applicationProperties = new Properties();
    
    public static Properties getApplicationProperties() {
        return applicationProperties;
    }
    
    private static void loadProperties() {
         try {
            applicationProperties.load(new FileInputStream("./src/eapli/expensemanager/expensemanager.properties"));

            //load a properties file from class path, inside static method
//            ClassLoader loader = ExpenseManager.class.getClassLoader();
//            if (loader == null) {
//                ClassLoader.getSystemClassLoader();
//            }
//            prop.load(loader.getResourceAsStream("/src/eapli/expensemanager/expensemanager.properties"));

        } catch (IOException ex) {
            //default values
            applicationProperties.setProperty("persistence.repositoryFactory", "eapli.expensemanager.persistence.JpaRepositoryFactory");

            ex.printStackTrace();
        }
    }

    private static void doBootstrap() {
        Bootstrap referenceDataBootstrap = new Bootstrap();
        
        SomeExpensesBootstrap sampleExpensesBootstrap = new SomeExpensesBootstrap();
        
        SomeIncomesBootstrap sampleIncomesBootstrap = new SomeIncomesBootstrap();
        
        SomeDefaultAlertLimitBootstrap defaultAlertLimits= new  SomeDefaultAlertLimitBootstrap();
    }
}
