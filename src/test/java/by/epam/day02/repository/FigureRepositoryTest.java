package by.epam.day02.repository;

import by.epam.day02.entity.Figure;
import by.epam.day02.observer.figureObservableImpl.EventManagerForFigure;
import by.epam.day02.observer.figureObserverImpl.ParamRegisterObserver;
import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.observer.figureObserverImpl.paramRegisterImpl.ParamRegisterForPyramid;
import by.epam.day02.exception.IllegalDataInputException;
import by.epam.day02.repository.specification.Specification;
import by.epam.day02.repository.specification.specificationImpl.PointSpecification;
import by.epam.day02.repository.specification.specificationImpl.PyramidAtFirstQuadrantSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureRepositoryTest {
    private static final Logger logger = LogManager.getLogger(FigureRepository.class);

    private static FigureRepository figureRepository;
    private static Point point1;
    private static Point point2;
    private static Point point3;
    private static Point point4;
    private static Point point5;
    private static Point point6;
    private static Point point7;
    private static Pyramid pyramid1;
    private static Pyramid pyramid2;

    @BeforeClass
    public static void initParam() throws IllegalDataInputException {
        point1 = new Point(1, 1, 0);
        point2 = new Point(3, 1, 0);
        point3 = new Point(1, 3, 0);
        point4 = new Point(1, 3, 3);
        point5 = new Point(1, 1, -2);
        point6 = new Point(3, 1, -2);
        point7 = new Point(1, 3, -2);

        pyramid1 = new Pyramid(point1, point2, point3, point4);
        pyramid2 = new Pyramid(point5, point6, point7, point4);

        figureRepository = new FigureRepository();

        figureRepository.addFigure(pyramid1);
        figureRepository.addFigure(point4);
        figureRepository.addFigure(pyramid2);
        figureRepository.addFigure(point3);
        figureRepository.addFigure(point7);
    }

    @Test
    public void shouldRepositoryReturnAllPoints() {
        List<Figure> expected = new ArrayList<>();
        expected.add(point4);
        expected.add(point3);
        expected.add(point7);

        Specification specification = new PointSpecification();
        List<Figure> actual = figureRepository.query(specification);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldRepositoryReturnAllPyramidsWithPositivePoints() {
        List<Figure> expected = new ArrayList<>();
        expected.add(pyramid1);

        Specification specification = new PyramidAtFirstQuadrantSpecification();
        List<Figure> actual = figureRepository.query(specification);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldRepositoryReturnParameterOfPyramid() {
        ParamRegisterObserver<EventManagerForFigure.SubscriptionEvent, Figure> expected = new ParamRegisterForPyramid(pyramid2);

        ParamRegisterObserver<EventManagerForFigure.SubscriptionEvent, Figure> actual = figureRepository.getParameters(pyramid2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldRepositoryReturnParameterOfPyramidChangedAfterChangingOfPyramid() {
        Pyramid tempPyramid = new Pyramid(point3, point4, point6, point7);

        figureRepository.addFigure(tempPyramid);

        tempPyramid.setPointA(point1);
        ParamRegisterObserver<EventManagerForFigure.SubscriptionEvent, Figure> expected = new ParamRegisterForPyramid(tempPyramid);
        ParamRegisterObserver<EventManagerForFigure.SubscriptionEvent, Figure> actual = figureRepository.getParameters(tempPyramid);

        figureRepository.removeFigure(tempPyramid);

        Assert.assertEquals(expected, actual);
    }
}
