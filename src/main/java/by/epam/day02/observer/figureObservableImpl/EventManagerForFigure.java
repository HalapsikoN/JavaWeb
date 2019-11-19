package by.epam.day02.observer.figureObservableImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.observer.Observable;
import by.epam.day02.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class EventManagerForFigure implements Observable {

    public enum SubscriptionEvent {
        CHANGE_POINT
    }

    private Figure figure;
    private List<Observer> listeners = new ArrayList<>();

    public EventManagerForFigure(Figure figure) {
        this.figure = figure;
    }

    public void subscribe(Observer listener) {
        listeners.add(listener);
    }

    public void unsubscribe(Observer listener) {
        listeners.remove(listener);
    }

    public void notifyAllSubscribers(SubscriptionEvent event) {
        for (Observer listener : listeners) {
            listener.update(event, figure);
        }
    }
}
