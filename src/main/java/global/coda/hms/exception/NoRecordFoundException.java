package global.coda.hms.exception;

/**
 * The type No record found exception.
 */
public class NoRecordFoundException extends Exception {
    /**
     * Instantiates a new No record found exception.
     */
    public NoRecordFoundException() {
    }

    /**
     * Instantiates a new No record found exception.
     *
     * @param message the message
     */
    public NoRecordFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new No record found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NoRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new No record found exception.
     *
     * @param cause the cause
     */
    public NoRecordFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new No record found exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public NoRecordFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
