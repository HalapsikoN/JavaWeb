package by.epam.day02.observer;

import by.epam.day02.entity.Figure;
import by.epam.day02.observer.figureObservableImpl.EventManagerForFigure;

public interface Observer {
    void update(EventManagerForFigure.SubscriptionEvent event, Figure figure);
}
