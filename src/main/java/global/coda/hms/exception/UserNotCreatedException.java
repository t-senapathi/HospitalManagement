package global.coda.hms.exception;

/**
 * The type User not created exception.
 */
public class UserNotCreatedException extends Exception {
    /**
     * Instantiates a new User not created exception.
     */
    public UserNotCreatedException() {
    }

    /**
     * Instantiates a new User not created exception.
     *
     * @param message the message
     */
    public UserNotCreatedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new User not created exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new User not created exception.
     *
     * @param cause the cause
     */
    public UserNotCreatedException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new User not created exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UserNotCreatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
