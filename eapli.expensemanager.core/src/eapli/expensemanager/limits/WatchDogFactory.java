/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.limits;

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

    public LimitsWatchDog buildWatchDogLimits(Observer obs) {
        LimitsWatchDog watchDog = new LimitsWatchDog();
        watchDog.addObserver(obs);
        return watchDog;
    }

    public Observable buildWatchDogSavings(Observer obs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
