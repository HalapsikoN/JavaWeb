package by.epam.day02.entity.figureImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.observer.Observer;
import by.epam.day02.observer.figureObservableImpl.EventManagerForFigure;

import java.util.Objects;
import java.util.UUID;

public class Pyramid implements Figure {

    private EventManagerForFigure eventManagerForFigure;

    private final String id = UUID.randomUUID().toString();
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Pyramid(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.eventManagerForFigure = new EventManagerForFigure(this);
    }

    public Pyramid() {
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
        eventManagerForFigure.notifyAllSubscribers(EventManagerForFigure.SubscriptionEvent.CHANGE_POINT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pyramid pyramid = (Pyramid) o;
        return pointA.equals(pyramid.pointA) &&
                pointB.equals(pyramid.pointB) &&
                pointC.equals(pyramid.pointC) &&
                pointD.equals(pyramid.pointD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC, pointD);
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
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
