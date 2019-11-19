package by.epam.day02.repository.specification.specificationImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.repository.specification.Specification;

public class PyramidAtFirstQuadrantSpecification implements Specification {
    private boolean isAtFirstQuadrantPoint(Point point) {
        double x = point.getX();
        double y = point.getY();
        double z = point.getZ();
        return x >= 0 && y >= 0 && z >= 0;
    }

    @Override
    public boolean specify(Figure figure) {
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            Point pA = pyramid.getPointA();
            Point pB = pyramid.getPointB();
            Point pC = pyramid.getPointC();
            Point pD = pyramid.getPointD();
            return isAtFirstQuadrantPoint(pA) &&
                    isAtFirstQuadrantPoint(pB) &&
                    isAtFirstQuadrantPoint(pC) &&
                    isAtFirstQuadrantPoint(pD);
        }
        return false;
    }
}
