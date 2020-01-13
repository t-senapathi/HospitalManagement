package global.coda.hms.exception;

import global.coda.hms.constant.HttpStatusConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The type System exception.
 */
@Provider
public class SystemException extends Exception implements ExceptionMapper<SystemException> {
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
    private static final Logger LOGGER = LogManager.getLogger(SystemException.class);
    /**
     * Preparing the exception response .
     * @param exception exception
     * @return Response obj
     */
    @Override
    public Response toResponse(SystemException exception) {
        LOGGER.error(exception.getMessage());
        return Response.status(HttpStatusConstant.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
