package by.epam.day02.exception;

public class IllegalDataInputException extends Exception {
    public IllegalDataInputException() {
        super();
    }

    public IllegalDataInputException(String message) {
        super(message);
    }

    public IllegalDataInputException(Exception e) {
        super(e);
    }

    public IllegalDataInputException(String message, Exception e) {
        super(message, e);
    }
}
