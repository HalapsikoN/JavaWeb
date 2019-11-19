package by.epam.day02.comparator;

import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.entity.figureImpl.Pyramid;

import java.util.Comparator;

public class PyramidFirstPointComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        Point x1=o1.getPointA();
        Point p2=o2.getPointA();
        PointXComparator pointXComparator=new PointXComparator();
        return pointXComparator.compare(x1, p2);
    }
}
