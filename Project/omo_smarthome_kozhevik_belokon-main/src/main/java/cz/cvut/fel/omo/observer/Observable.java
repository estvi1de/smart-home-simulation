package cz.cvut.fel.omo.observer;

public interface Observable {
    void notifyObservers(int code);

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);
}