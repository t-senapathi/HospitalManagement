package global.coda.hms.api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.delegate.PatientDelegate;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.ResponseEntity;

import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Patient api.
 */
@Path("/patient")
public class PatientApi {
    private static final Logger LOGGER = LogManager.getLogger(DoctorApi.class);

    /**
     * Create patient api response entity.
     *
     * @param patient the patient
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @POST
    @Path("/createpatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> createPatientApi(Patient patient) throws SystemException, BusinessException {
        LOGGER.traceEntry(patient.toString());
        PatientDelegate patientDelegate = new PatientDelegate();
        patient = patientDelegate.createPatientDelegate(patient);
        return new ResponseEntity<>().setData(patient).setStatusCode(HttpStatusConstant.OK);

    }

    /**
     * Read patient api response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @GET
    @Path("/readpatient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> readPatientApi(@PathParam("id") int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        PatientDelegate patientDelegate = new PatientDelegate();
        Patient patient = patientDelegate.readPatientDelegate(id);
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(patient).setStatusCode(HttpStatusConstant.OK);
    }

    /**
     * Read all patient api response entity.
     *
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @GET
    @Path("/readallpatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> readAllPatientApi() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        PatientDelegate patientDelegate = new PatientDelegate();
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(patientDelegate.readAllPatientDelegate()).setStatusCode(HttpStatusConstant.OK);
    }

    /**
     * Delete patient api response.
     *
     * @param id the id
     * @return the response
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    @DELETE
    @Path("/deletepatient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePatientApi(@PathParam("id") int id) throws BusinessException, SystemException {
        LOGGER.traceEntry(String.valueOf(id));
        PatientDelegate patientDelegate = new PatientDelegate();
        patientDelegate.deletePatientDelegate(id);
        LOGGER.traceExit();
        return Response.status(HttpStatusConstant.OK_NO_CONTENT).build();
    }

    /**
     * Update patient api response.
     *
     * @param patient the patient
     * @return the response
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @PUT
    @Path("/updatepatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatientApi(Patient patient) throws SystemException, BusinessException {
        LOGGER.traceEntry(patient.toString());
        PatientDelegate patientDelegate = new PatientDelegate();
        patientDelegate.updatePatientDelegate(patient);
        LOGGER.traceExit();
        return Response.status(HttpStatusConstant.OK_NO_CONTENT).build();
    }
}
