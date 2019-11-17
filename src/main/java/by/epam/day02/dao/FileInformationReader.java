package by.epam.day02.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInformationReader implements AutoCloseable {

    private final static Logger logger = LogManager.getLogger(FileInformationReader.class);
    private BufferedReader fileReader;

    public FileInformationReader(File file) throws IOException {
        fileReader = new BufferedReader(new FileReader(file));
    }

    public String getLine(int number) throws IOException {
        String result = "";
        while (number-- > 0) {
            result = fileReader.readLine();
        }
        return result;
    }

    public String getFirstLine() throws IOException {
        return fileReader.readLine();
    }

    public List<String> getAllLinesWithString(String searchString) throws IOException {
        List<String> list = new ArrayList<>();
        while (fileReader.ready()) {
            String string = fileReader.readLine();
            if (string.contains(searchString)) {
                list.add(string);
            } else {
                logger.info("String (" + string + ") doesn't contains string (" + searchString + ")");
            }
        }
        return list;
    }

    public List<String> readAllFile() throws IOException {
        List<String> list = new ArrayList<>();
        while (fileReader.ready()) {
            list.add(fileReader.readLine());
        }
        return list;
    }

    public void close() throws IOException {
        fileReader.close();
    }

}
