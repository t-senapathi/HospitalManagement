package global.coda.hms.exception;

/**
 * The type Db constraint violation exception.
 */
public class DbConstraintViolationException extends Exception {
    /**
     * Instantiates a new Db constraint violation exception.
     */
    public DbConstraintViolationException() {
    }

    /**
     * Instantiates a new Db constraint violation exception.
     *
     * @param message the message
     */
    public DbConstraintViolationException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Db constraint violation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DbConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Db constraint violation exception.
     *
     * @param cause the cause
     */
    public DbConstraintViolationException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Db constraint violation exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public DbConstraintViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
