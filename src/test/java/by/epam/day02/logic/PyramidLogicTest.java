package by.epam.day02.logic;

import by.epam.day02.dao.FileInformationReader;
import by.epam.day02.dao.Parser;
import by.epam.day02.dao.ParserOfTwelvePoints;
import by.epam.day02.entity.Point;
import by.epam.day02.entity.Pyramid;
import by.epam.day02.exception.IllegalDataInFileExceprion;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.observer.Registrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidLogicTest {
    private static final Logger logger = LogManager.getLogger(PyramidLogicTest.class);

    private final double DELTA = 0.1;
    private static PyramidLogic pyramidLogic;
    private static Pyramid pyramid;
    private static final int NUMBER_OF_POINTS = 4;
    private static final int NUMBER_OF_POINT_CHARACTERISTICS = 3;
    private static final String FILE_PATH = "src/test/resources/File.txt";

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
    }

    @Test
    public void shouldIsPyramidReturnTrueIfPyramidIsPyramid() {
        Assert.assertTrue(pyramidLogic.isPyramid(pyramid));
    }

    @Test
    public void shouldSquareOfPyramidReturnCorrectSquareOfPyramid() throws NotPyramidException {
        double expected = 104.62 + 50 + 130;
        double actual = pyramidLogic.findSquareOfPyramid(pyramid);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void shouldVolumeOfPyramidReturnCorrectVolumeOfPyramid() throws NotPyramidException {
        double expected = 216.667;
        double actual = pyramidLogic.findVolumeOfPyramid(pyramid);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void shouldIsPyramidBaseOnCoordinatePlaneReturnTrueIfPyramidStaysOnCoordinatePlane() {
        Assert.assertFalse(pyramidLogic.isPyramidStayOnCoordinatePlaneBySide(pyramid));
    }

    @Test
    public void shouldSplitByCoordinatePlaneReturnCorrectRatioOfSplittingThePyramid() throws NotPyramidException {
        double expected = 48 / (216.667 - 48);
        double actual = pyramidLogic.findRatioOfPartsOfPyramidSplitedByCoordinatePlaneXY(pyramid);
        Assert.assertEquals(actual, expected, DELTA);
    }
}
