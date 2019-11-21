package by.epam.day02.logic;

import by.epam.day02.entity.accessory.Vector;
import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.exception.NotPyramidException;


public class PyramidLogic {

    private final static PyramidLogic instance = new PyramidLogic();

    private PyramidLogic() {
    }

    public static PyramidLogic getInstance() {
        return instance;
    }

    public double findSquareOfPyramid(Pyramid pyramid) throws NotPyramidException {
        if (!isPyramid(pyramid)) {
            throw new NotPyramidException("at method \"findSquareOfPyramid\"");
        } else {
            Point pointA = pyramid.getPointA();
            Point pointB = pyramid.getPointB();
            Point pointC = pyramid.getPointC();
            Point pointD = pyramid.getPointD();
            return findSquareOfTriangle(pointA, pointB, pointC) +
                    findSquareOfTriangle(pointB, pointC, pointD) +
                    findSquareOfTriangle(pointC, pointD, pointA) +
                    findSquareOfTriangle(pointD, pointA, pointB);
        }

    }

    public double findVolumeOfPyramid(Pyramid pyramid) throws NotPyramidException {
        if (!isPyramid(pyramid)) {
            throw new NotPyramidException("at method \"findSquareOfPyramid\"");
        } else {
            Point pointA = pyramid.getPointA();
            Point pointB = pyramid.getPointB();
            Point pointC = pyramid.getPointC();
            Point pointD = pyramid.getPointD();
            Vector vectorDA = new Vector(pointD, pointA);
            Vector vectorDB = new Vector(pointD, pointB);
            Vector vectorDC = new Vector(pointD, pointC);
            double X1 = vectorDA.getX();
            double Y1 = vectorDA.getY();
            double Z1 = vectorDA.getZ();
            double X2 = vectorDB.getX();
            double Y2 = vectorDB.getY();
            double Z2 = vectorDB.getZ();
            double X3 = vectorDC.getX();
            double Y3 = vectorDC.getY();
            double Z3 = vectorDC.getZ();
            return Math.abs((X1 * Y2 * Z3 + Z1 * X2 * Y3 + Y1 * Z2 * X3 - Z1 * Y2 * X3 - X1 * Z2 * Y3 - Y1 * X2 * Z3) / 6);
        }
    }

    public double findRatioOfPartsOfPyramidSplitedByCoordinatePlaneXY(Pyramid pyramid) throws NotPyramidException {
        //Point highZPoint1=findHighZPoint(pyramid);
        Point highZPoint = pyramid.getPointD();
        Point pA1 = findPointOfSplitByPlaneXY(highZPoint, pyramid.getPointA());
        Point pB1 = findPointOfSplitByPlaneXY(highZPoint, pyramid.getPointB());
        Point pC1 = findPointOfSplitByPlaneXY(highZPoint, pyramid.getPointC());
        Pyramid pyramid1 = new Pyramid(pA1, pB1, pC1, highZPoint);
        double volume = findVolumeOfPyramid(pyramid);
        double volume1 = findVolumeOfPyramid(pyramid1);
        return (volume1) / (volume - volume1);
    }

    public boolean isPyramid(Pyramid pyramid) {
        Point pA = pyramid.getPointA();
        Point pB = pyramid.getPointB();
        Point pC = pyramid.getPointC();
        Point pD = pyramid.getPointD();

        if (pA.getX() == pB.getX() && pB.getX() == pC.getX() && pC.getX() == pD.getX()) {
            return false;
        }
        if (pA.getZ() == pB.getZ() && pB.getZ() == pC.getZ() && pC.getZ() == pD.getZ()) {
            return false;
        }
        if (pA.getY() == pB.getY() && pB.getY() == pC.getY() && pC.getY() == pD.getY()) {
            return false;
        }
        return true;
    }

    public boolean isPyramidStayOnCoordinatePlaneBySide(Pyramid pyramid) {
        Point pA = pyramid.getPointA();
        Point pB = pyramid.getPointB();
        Point pC = pyramid.getPointC();
        return (pA.getX() == 0 && pB.getX() == 0 && pC.getX() == 0) ||
                (pA.getY() == 0 && pB.getY() == 0 && pC.getY() == 0) ||
                (pA.getZ() == 0 && pB.getZ() == 0 && pC.getZ() == 0);
    }

    private double findDistanceBetweenPoints(Point p2, Point p1) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2) + Math.pow(p2.getZ() - p1.getZ(), 2));
    }

    private double findSquareOfTriangle(Point pA, Point pB, Point pC) {
        double sideAB = findDistanceBetweenPoints(pA, pB);
        double sideAC = findDistanceBetweenPoints(pA, pC);
        double sideCB = findDistanceBetweenPoints(pC, pB);
        double semiPerimeter = (sideAB + sideAC + sideCB) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideAB) * (semiPerimeter - sideAC) * (semiPerimeter - sideCB));
    }

    private Point findHighZPoint(Pyramid pyramid) {
        Point highZPoint = pyramid.getPointA();
        Point pointB = pyramid.getPointB();
        Point pointC = pyramid.getPointC();
        Point pointD = pyramid.getPointD();
        if (highZPoint.getZ() < pointB.getZ()) {
            highZPoint = pointB;
        }
        if (highZPoint.getZ() < pointC.getZ()) {
            highZPoint = pointC;
        }
        if (highZPoint.getZ() < pointD.getZ()) {
            highZPoint = pointD;
        }
        return highZPoint;
    }

    private Point findPointOfSplitByPlaneXY(Point pHigh, Point pLow) {
        double newX;
        double newY;
        if (pHigh.getX() > pLow.getX()) {
            newX = pHigh.getX() - ((pHigh.getX() - pLow.getX()) * pHigh.getZ() / (pHigh.getZ() - pLow.getZ()));
        } else {
            newX = ((pLow.getX() - pHigh.getX()) * pHigh.getZ() / (pHigh.getZ() - pLow.getZ())) - pHigh.getX();
        }
        if (pHigh.getY() > pLow.getY()) {
            newY = pHigh.getY() - ((pHigh.getY() - pLow.getY()) * pHigh.getZ() / (pHigh.getZ() - pLow.getZ()));
        } else {
            newY = pHigh.getY() - ((pHigh.getY() - pLow.getY()) * pHigh.getZ() / (pHigh.getZ() - pLow.getZ()));
        }
        return new Point(newX, newY, 0);
    }
}
