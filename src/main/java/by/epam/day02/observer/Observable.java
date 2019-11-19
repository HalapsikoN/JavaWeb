package by.epam.day02.observer;

import by.epam.day02.observer.figureObservableImpl.EventManagerForFigure;

public interface Observable {

    void subscribe(Observer listener);

    void unsubscribe(Observer listener);

    void notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent event);
}
