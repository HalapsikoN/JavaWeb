package by.epam.day02.observer;

import by.epam.day02.entity.Pyramid;

public interface EventListener {
    void update(EventType eventType, Pyramid pyramid);
}
