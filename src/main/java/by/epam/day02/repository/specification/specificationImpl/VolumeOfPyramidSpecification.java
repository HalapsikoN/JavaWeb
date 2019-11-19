package by.epam.day02.repository.specification.specificationImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.logic.PyramidLogic;
import by.epam.day02.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolumeOfPyramidSpecification implements Specification {

    private static final Logger logger = LogManager.getLogger(VolumeOfPyramidSpecification.class);
    private double minVolume;
    private double maxVolume;

    public VolumeOfPyramidSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Figure figure) {
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            PyramidLogic pyramidLogic = PyramidLogic.getInstance();
            double pyramidVolume;
            try {
                pyramidVolume = pyramidLogic.findVolumeOfPyramid(pyramid);
            } catch (NotPyramidException e) {
                logger.error(e.getMessage(), e);
                return false;
            }
            return minVolume <= pyramidVolume && pyramidVolume <= maxVolume;
        }
        return false;
    }
}
