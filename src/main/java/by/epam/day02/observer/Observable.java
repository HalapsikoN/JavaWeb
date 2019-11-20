package by.epam.day02.observer;

public interface Observable<Event, Observer> {

    void subscribe(Observer listener);

    void unsubscribe(Observer listener);

    void notifyAllSubscribers(Event event);
}
