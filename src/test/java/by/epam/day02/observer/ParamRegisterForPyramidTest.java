package by.epam.day02.observer;

import by.epam.day02.dao.loader.CreatorPyramid;
import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.entity.paramRegisterImpl.ParamRegisterForPyramid;
import by.epam.day02.exception.NotPyramidException;
import by.epam.day02.logic.PyramidLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

public class ParamRegisterForPyramidTest {
    private static final Logger logger = LogManager.getLogger(ParamRegisterForPyramid.class);

    private final double DELTA = 0.1;
    private static PyramidLogic pyramidLogic;
    private static Pyramid pyramid;
    private static final String FILE_PATH = "src/test/resources/File.txt";

    private static ParamRegisterForPyramid register;

    @BeforeClass
    public static void initParam() {
        pyramidLogic = PyramidLogic.getInstance();

        File file = new File(FILE_PATH);

        CreatorPyramid creatorPyramid = new CreatorPyramid();
        pyramid = creatorPyramid.createPyramidFromFile(file).get(0);

        register = new ParamRegisterForPyramid(pyramid);
        pyramid.subscribe(register);
    }

    @Test
    public void shouldChangeTheRegisterSquareAfterChangingTheParametersOfPyramid() throws NotPyramidException {
        Point point = new Point(0, 0, 0);
        pyramid.setPointA(point);
        double expected = pyramidLogic.findSquareOfPyramid(pyramid);
        double actual = register.getSquare();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void shouldChangeTheRegisterVolumeAfterChangingTheParametersOfPyramid() throws NotPyramidException {
        Point point = new Point(0, 0, 20);
        pyramid.setPointD(point);
        double expected = pyramidLogic.findVolumeOfPyramid(pyramid);
        double actual = register.getVolume();
        Assert.assertEquals(expected, actual, DELTA);
    }
}
