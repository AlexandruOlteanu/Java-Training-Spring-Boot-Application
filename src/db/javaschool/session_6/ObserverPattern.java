package db.javaschool.session_6;


import java.util.ArrayList;
import java.util.List;

class Subject {
    private int state;
    public List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers("New state is " + state);
    }

    public void attachObserver(Observer observer) { // PRESS THE SUBSCRIBE BUTTON
        observers.add(observer);
    }

    public void notifyObservers(String msg) {
        for (Observer observer : observers)
            observer.receiveUpdate(msg);
    }
}

class Observer {
    Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attachObserver(this);
    }
    public void receiveUpdate(String msg) {
        System.out.println(msg);
    }
}
