package mode.design.Observer;

import java.util.ArrayList;

/**
 * @author : ldy
 * @version : 1.0
 */
abstract class Observable {
    private ArrayList<Observer> observers = new ArrayList();
    void addObserver(Observer observer){
        observers.add(observer);
    }
    void removeObserver(Observer observer){
        observers.remove(observer);
    }
    void notifyObserver(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
