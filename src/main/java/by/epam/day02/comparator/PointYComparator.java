package by.epam.day02.comparator;

import by.epam.day02.entity.figureImpl.Point;

import java.util.Comparator;

public class PointYComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double y1=o1.getY();
        double y2=o2.getY();
        if(y1>y2){
            return 1;
        }else if(y1<y2){
            return -1;
        }else {
            return 0;
        }
    }
}
