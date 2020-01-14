package global.coda.hms.exceptionmapper;

import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.exception.SystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The type System exception mapper.
 */
@Provider
public class SystemExceptionMapper implements ExceptionMapper<SystemException> {
    private static final Logger LOGGER = LogManager.getLogger(SystemExceptionMapper.class);

    /**
     * @param exception handles SystemException
     * @return toResponse
     */
    @Override
    public Response toResponse(SystemException exception) {
        LOGGER.error(exception.getMessage());
        return Response.status(HttpStatusConstant.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
