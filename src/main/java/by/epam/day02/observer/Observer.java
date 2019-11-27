package by.epam.day02.observer;

import by.epam.day02.entity.Figure;

public interface Observer<E, F extends Figure> {
    void update(E event, F figure);
}
