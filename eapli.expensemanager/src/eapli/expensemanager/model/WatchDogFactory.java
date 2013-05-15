/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mcn
 */
public class WatchDogFactory {

    private static WatchDogFactory instance = null;

    private WatchDogFactory() {
    }

    public static WatchDogFactory getInstance() {
        if (instance == null) {
            instance = new WatchDogFactory();
        }
        return instance;
    }

    public WatchDogLimits buildWatchDogLimits(Observer obs) {
        WatchDogLimits watchDog = new WatchDogLimits();
        watchDog.addObserver(obs);
        return watchDog;
    }

    public Observable buildWatchDogSavings(Observer obs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
