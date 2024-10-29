package behavioral2;

import java.util.List;

public class Observable {

    private List<Observer> observers;

    public void subscribe(Observer observer) {

        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {

        observers.remove(observer);
    }

    public void notifySubscribers(String event) {

        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
