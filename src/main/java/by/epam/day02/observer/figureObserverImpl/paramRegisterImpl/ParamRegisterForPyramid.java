package by.epam.day02.observer.figureObserverImpl.paramRegisterImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.logic.PyramidLogic;
import by.epam.day02.observer.figureObservableImpl.EventManagerForFigure;
import by.epam.day02.observer.figureObserverImpl.ParamRegisterObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class ParamRegisterForPyramid implements ParamRegisterObserver<EventManagerForFigure.SubscriptionEvent, Figure> {

    private static final Logger logger = LogManager.getLogger(ParamRegisterForPyramid.class);

    private PyramidLogic pyramidLogic;
    private double square;
    private double volume;

    public ParamRegisterForPyramid(Pyramid pyramid) {
        pyramidLogic = PyramidLogic.getInstance();
        try {
            square = pyramidLogic.findSquareOfPyramid(pyramid);
            volume = pyramidLogic.findVolumeOfPyramid(pyramid);
        } catch (NotPyramidException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParamRegisterForPyramid that = (ParamRegisterForPyramid) o;
        return Double.compare(that.square, square) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square, volume);
    }

    @Override
    public String toString() {
        return "ParamRegisterForPyramid{" +
                "square=" + square +
                ", volume=" + volume +
                '}';
    }

    @Override
    public void update(EventManagerForFigure.SubscriptionEvent event, Figure figure) {
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            logger.info("the figure is pyramid");
            try {
                square = pyramidLogic.findSquareOfPyramid(pyramid);
                volume = pyramidLogic.findVolumeOfPyramid(pyramid);
            } catch (NotPyramidException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
