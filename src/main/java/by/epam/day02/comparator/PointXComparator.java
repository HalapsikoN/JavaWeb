package by.epam.day02.comparator;

import by.epam.day02.entity.figureImpl.Point;

import java.util.Comparator;

public class PointXComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double x1=o1.getX();
        double x2=o2.getX();
        if(x1>x2){
            return 1;
        }else if(x1<x2){
            return -1;
        }else {
            return 0;
        }
    }
}
