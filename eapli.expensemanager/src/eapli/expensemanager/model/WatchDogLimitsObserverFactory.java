/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.util.Observer;

/**
 *
 * @author mcn
 */
public class WatchDogLimitsObserverFactory {
      private static WatchDogLimitsObserverFactory instance=null ;
      WatchDogLimits watchDogLimits;
      private WatchDogLimitsObserverFactory(){
            watchDogLimits=new WatchDogLimits();
      }
      public static WatchDogLimitsObserverFactory getInstance(){
            if (instance==null){
                  instance=new WatchDogLimitsObserverFactory(); 
            }
            return instance;
      }
      public WatchDogLimits getWatchDogLimits(){
            return watchDogLimits;
      }
      public void addObserver(Observer obj){
            watchDogLimits.addObserver(obj);
      }
}
