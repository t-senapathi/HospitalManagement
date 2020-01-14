package global.coda.hms.exception;


/**
 * The type System exception.
 */

public class SystemException extends Exception{
    /**
     * Instantiates a new System exception.
     */
    public SystemException() {
    }

    /**
     * Instantiates a new System exception.
     *
     * @param message the message
     */
    public SystemException(String message) {
        super(message);
    }

    /**
     * Instantiates a new System exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new System exception.
     *
     * @param cause the cause
     */
    public SystemException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new System exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
