package bg.softuni.automappingobjectsexercise.exception;

public class IncorrectURLException extends RuntimeException {
    public IncorrectURLException() {
    }

    public IncorrectURLException(String message) {
        super(message);
    }

    public IncorrectURLException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectURLException(Throwable cause) {
        super(cause);
    }

    public IncorrectURLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
