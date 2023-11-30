package bg.softuni.springdataintro.exception;

public class EntityDoesNotExist extends RuntimeException {

    public EntityDoesNotExist() {
    }

    public EntityDoesNotExist(String message) {
        super(message);
    }

    public EntityDoesNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDoesNotExist(Throwable cause) {
        super(cause);
    }

    public EntityDoesNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
