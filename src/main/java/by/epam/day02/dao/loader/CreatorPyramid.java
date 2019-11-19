package by.epam.day02.dao.loader;

import by.epam.day02.dao.FileInformationReader;
import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.exception.DAOException;
import by.epam.day02.util.Impl.ParserOfTwelvePoints;
import by.epam.day02.util.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreatorPyramid {

    private static final Logger logger = LogManager.getLogger(CreatorPyramid.class);

    private static final int NUMBER_OF_POINTS = 4;
    private static final int NUMBER_OF_POINT_CHARACTERISTICS = 3;

    public List<Pyramid> createPyramidFromFile(File file) {

        List<Pyramid> pyramidList = new ArrayList<>();

        List<String> stringList = new ArrayList<>();
        try {
            FileInformationReader fileInformationReader = FileInformationReader.getInstance();
            stringList = fileInformationReader.readAllFile(file);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }


        Parser<List<Double>, String> parser = new ParserOfTwelvePoints();
        for (String string : stringList) {
            List<Double> listOfDouble = parser.parse(string);
            if (listOfDouble.isEmpty()) {
                logger.error("Empty list of point values");
                continue;
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

            pyramidList.add(new Pyramid(pA, pB, pC, pD));
        }
        return pyramidList;
    }
}
