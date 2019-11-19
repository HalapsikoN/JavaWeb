package by.epam.day02.comparator;

import by.epam.day02.entity.figureImpl.Point;

import java.util.Comparator;

public class PointZComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double z1=o1.getZ();
        double z2=o2.getZ();
        if(z1>z2){
            return 1;
        }else if(z1<z2){
            return -1;
        }else {
            return 0;
        }
    }
}
