package by.epam.day02.observer;

public interface Observable<E, O> {

    void subscribe(O listener);

    void unsubscribe(O listener);

    void notifyAllSubscribers(E event);
}
