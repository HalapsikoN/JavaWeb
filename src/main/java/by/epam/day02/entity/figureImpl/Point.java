package by.epam.day02.entity.figureImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.observer.Observer;
import by.epam.day02.observer.figureObservableImpl.EventManagerForFigure;

import java.util.Objects;
import java.util.UUID;

public class Point implements Figure {

    private EventManagerForFigure eventManagerForFigure;

    private final String id = UUID.randomUUID().toString();
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.eventManagerForFigure = new EventManagerForFigure(this);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public String getId() {
        return id;
    }

    public void subscribe(Observer listener) {
        eventManagerForFigure.subscribe(listener);
    }

    public void unsubscribe(Observer listener) {
        eventManagerForFigure.unsubscribe(listener);
    }
}
