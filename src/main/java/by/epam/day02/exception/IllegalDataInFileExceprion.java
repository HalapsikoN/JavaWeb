package by.epam.day02.exception;

public class IllegalDataInFileExceprion extends Exception {
    public IllegalDataInFileExceprion() {
        super();
    }

    public IllegalDataInFileExceprion(String message) {
        super(message);
    }

    public IllegalDataInFileExceprion(Exception e) {
        super(e);
    }

    public IllegalDataInFileExceprion(String message, Exception e) {
        super(message, e);
    }
}
