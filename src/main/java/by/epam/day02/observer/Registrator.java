package by.epam.day02.observer;

import by.epam.day02.entity.Pyramid;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.logic.PyramidLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Registrator implements EventListener{

    private static final Logger logger= LogManager.getLogger(Registrator.class);

    private PyramidLogic pyramidLogic;
    private double square;
    private double volume;

    public Registrator(Pyramid pyramid) {
        pyramidLogic=new PyramidLogic();
        try {
            square=pyramidLogic.findSquareOfPyramid(pyramid);
            volume=pyramidLogic.findVolumeOfPyramid(pyramid);
        } catch (NotPyramidException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Registrator() {
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public void update(EventType eventType, Pyramid pyramid) {
        try {
            square=pyramidLogic.findSquareOfPyramid(pyramid);
            volume=pyramidLogic.findVolumeOfPyramid(pyramid);
        } catch (NotPyramidException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registrator that = (Registrator) o;
        return Double.compare(that.square, square) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square, volume);
    }

    @Override
    public String toString() {
        return "Registrator{" +
                "square=" + square +
                ", volume=" + volume +
                '}';
    }
}
