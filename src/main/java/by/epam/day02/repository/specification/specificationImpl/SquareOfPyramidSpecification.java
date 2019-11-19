package by.epam.day02.repository.specification.specificationImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.logic.PyramidLogic;
import by.epam.day02.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareOfPyramidSpecification implements Specification {

    private static final Logger logger = LogManager.getLogger(SquareOfPyramidSpecification.class);
    private double minSquare;
    private double maxSquare;

    public SquareOfPyramidSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Figure figure) {
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            PyramidLogic pyramidLogic = PyramidLogic.getInstance();
            double pyramidVolume;
            try {
                pyramidVolume = pyramidLogic.findSquareOfPyramid(pyramid);
            } catch (NotPyramidException e) {
                logger.error(e.getMessage(), e);
                return false;
            }
            return minSquare <= pyramidVolume && pyramidVolume <= maxSquare;
        }
        return false;
    }
}
