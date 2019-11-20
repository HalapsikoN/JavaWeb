package by.epam.day02.observer;

public interface Observer<Event, ElementToObserve> {
    void update(Event event, ElementToObserve figure);
}
