package bg.softuni.automappingobjectsexercise.exception;

public class NonNegativeValueException extends RuntimeException{
    public NonNegativeValueException() {
    }

    public NonNegativeValueException(String message) {
        super(message);
    }

    public NonNegativeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonNegativeValueException(Throwable cause) {
        super(cause);
    }

    public NonNegativeValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
