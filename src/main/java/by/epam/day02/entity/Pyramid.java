package by.epam.day02.entity;

import by.epam.day02.observer.EventManager;
import by.epam.day02.observer.EventType;

import java.util.Objects;

public class Pyramid implements Figure {

    //for observer
    public EventManager events;

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Pyramid(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.events=new EventManager();
    }

    public Pyramid() {
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        events.notify(EventType.CHANGE_POINT, this);
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        events.notify(EventType.CHANGE_POINT, this);
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        events.notify(EventType.CHANGE_POINT, this);
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
        events.notify(EventType.CHANGE_POINT, this);
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
}
