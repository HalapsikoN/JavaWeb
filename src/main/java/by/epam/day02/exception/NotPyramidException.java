package by.epam.day02.exception;

public class NotPyramidException extends Exception {
    public NotPyramidException() {
        super();
    }

    public NotPyramidException(String message) {
        super(message);
    }

    public NotPyramidException(Exception e) {
        super(e);
    }

    public NotPyramidException(String message, Exception e) {
        super(message, e);
    }
}
