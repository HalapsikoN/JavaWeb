package by.epam.day02.util.Impl;

import by.epam.day02.util.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserOfTwelvePoints implements Parser<List<Double>, String> {

    private final static Logger logger = LogManager.getLogger(ParserOfTwelvePoints.class);
    private final Pattern pattern = Pattern.compile("(([+-]?\\d+([.]\\d+)?\\s){11}([+-]?\\d+([.]\\d+)?))");

    @Override
    public List<Double> parse(String string) {
        List<Double> listResult = new ArrayList<>();

        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String splitter = " ";
            String[] numbers = string.split(splitter);

            for (String number : numbers) {
                listResult.add(Double.valueOf(number));
            }
        } else {
            logger.warn("String doesn't match the regex");
        }

        return listResult;
    }
}
