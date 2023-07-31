package bg.softuni.automappingobjectsexercise.exception;

public class IncorrectStringFormatException extends RuntimeException {
    public IncorrectStringFormatException() {
    }

    public IncorrectStringFormatException(String message) {
        super(message);
    }

    public IncorrectStringFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectStringFormatException(Throwable cause) {
        super(cause);
    }

    public IncorrectStringFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
