package by.epam.day02.comparator;

import by.epam.day02.entity.figureImpl.Point;

import java.util.Comparator;

public class PointIdComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
