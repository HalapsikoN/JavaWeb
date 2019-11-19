package by.epam.day02.logic;

import by.epam.day02.dao.loader.CreatorPyramid;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.exception.NotPyramidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class PyramidLogicTest {
    private static final Logger logger = LogManager.getLogger(PyramidLogicTest.class);

    private final double DELTA = 0.1;
    private static PyramidLogic pyramidLogic;
    private static Pyramid pyramid;
    private static final String FILE_PATH = "src/test/resources/File.txt";

    @BeforeClass
    public static void initParam() {
        pyramidLogic = PyramidLogic.getInstance();

        File file = new File(FILE_PATH);
        CreatorPyramid creatorPyramid = new CreatorPyramid();
        pyramid = creatorPyramid.createPyramidFromFile(file).get(0);
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
