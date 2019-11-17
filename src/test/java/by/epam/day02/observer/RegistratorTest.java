package by.epam.day02.observer;

import by.epam.day02.dao.FileInformationReader;
import by.epam.day02.dao.Parser;
import by.epam.day02.dao.ParserOfTwelvePoints;
import by.epam.day02.entity.Point;
import by.epam.day02.entity.Pyramid;
import by.epam.day02.exception.IllegalDataInFileExceprion;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.logic.PyramidLogic;
import by.epam.day02.logic.PyramidLogicTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistratorTest {
    private static final Logger logger = LogManager.getLogger(Registrator.class);

    private final double DELTA = 0.1;
    private static PyramidLogic pyramidLogic;
    private static Pyramid pyramid;
    private static final int NUMBER_OF_POINTS = 4;
    private static final int NUMBER_OF_POINT_CHARACTERISTICS = 3;
    private static final String FILE_PATH = "src/test/resources/File.txt";

    private static Registrator registrator;

    @BeforeClass
    public static void initParam() throws IllegalDataInFileExceprion {
        pyramidLogic = new PyramidLogic();
        //читаю строку из файла
        File file = new File(FILE_PATH);
        String string = "";
        try (FileInformationReader fileReader = new FileInformationReader(file)) {
            string = fileReader.getFirstLine();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        //проверяю на соответсвие строки формату
        Parser<List<Double>, String> parser = new ParserOfTwelvePoints();
        List<Double> listOfDouble = parser.parse(string);
        if (listOfDouble.isEmpty()) {
            logger.error("Empty list of point values");
            throw new IllegalDataInFileExceprion();
        }
        //создаю пирамидку
        List<Point> listOfPoints = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_POINTS; ++i) {
            int j = 0;
            double x = listOfDouble.get(i * NUMBER_OF_POINT_CHARACTERISTICS + j++);
            double y = listOfDouble.get(i * NUMBER_OF_POINT_CHARACTERISTICS + j++);
            double z = listOfDouble.get(i * NUMBER_OF_POINT_CHARACTERISTICS + j);
            listOfPoints.add(new Point(x, y, z));
        }

        Point pA = listOfPoints.get(0);
        Point pB = listOfPoints.get(1);
        Point pC = listOfPoints.get(2);
        Point pD = listOfPoints.get(3);

        pyramid = new Pyramid(pA, pB, pC, pD);
        //создание и подписка регистратора
        registrator=new Registrator(pyramid);
        logger.info("Data from registrator after the creating the pyramid: "+registrator);
        pyramid.events.subscribe(EventType.CHANGE_POINT, registrator);
    }

    @Test
    public void shouldChangeTheRegistatorSquareAfterChangingTheParametersOfPyramid() throws NotPyramidException {
        Point point=new Point(0,0,0);
        pyramid.setPointA(point);
        double expected=pyramidLogic.findSquareOfPyramid(pyramid);
        double actual=registrator.getSquare();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void shouldChangeTheRegistatorVolumeAfterChangingTheParametersOfPyramid() throws NotPyramidException {
        Point point=new Point(0,0,20);
        pyramid.setPointD(point);
        double expected=pyramidLogic.findVolumeOfPyramid(pyramid);
        double actual=registrator.getVolume();
        Assert.assertEquals(expected, actual, DELTA);
    }
}
