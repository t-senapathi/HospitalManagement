package global.coda.hms.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import global.coda.hms.constant.HttpStatusConstant;
import global.coda.hms.delegate.DoctorDelegate;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.DoctorPatientAssign;
import global.coda.hms.model.DoctorPatientMapper;
import global.coda.hms.model.ResponseEntity;

import global.coda.hms.model.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Doctor api.
 */
@Path("/doctor")
public class DoctorApi {
    private static final Logger LOGGER = LogManager.getLogger(DoctorApi.class);

    /**
     * Create doctor api response entity.
     *
     * @param doctor the doctor
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @POST
    @Path("/createdoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> createDoctorApi(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        doctor = doctorDelegate.createDoctorDelegate(doctor);
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(doctor).setStatusCode(HttpStatusConstant.OK);

    }

    /**
     * Read doctor api response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @GET
    @Path("/readdoctor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> readDoctorApi(@PathParam("id") int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        Doctor doctor = doctorDelegate.readDoctorDelegate(id);
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(doctor).setStatusCode(HttpStatusConstant.OK);
    }

    /**
     * Read all doctor api response entity.
     *
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @GET
    @Path("/readalldoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> readAllDoctorApi() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(doctorDelegate.readAllDoctorDelegate()).setStatusCode(HttpStatusConstant.OK);
    }

    /**
     * Delete doctor api response.
     *
     * @param id the id
     * @return the response
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    @DELETE
    @Path("/deletedoctor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDoctorApi(@PathParam("id") int id) throws BusinessException, SystemException {
        LOGGER.traceEntry(String.valueOf(id));
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        doctorDelegate.deleteDoctorDelegate(id);
        LOGGER.traceExit();
        return Response.status(HttpStatusConstant.OK_NO_CONTENT).build();
    }

    /**
     * Update doctor api response.
     *
     * @param doctor the doctor
     * @return the response
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @PUT
    @Path("/updatedoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctorApi(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        doctorDelegate.updateDoctorDelegate(doctor);
        LOGGER.traceExit();
        return Response.status(HttpStatusConstant.OK_NO_CONTENT).build();
    }

    /**
     * Assign patient api response entity.
     *
     * @param doctorPatientAssign the doctor patient assign
     * @return the response entity
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    @POST
    @Path("/assignPatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> assignPatientApi(DoctorPatientAssign doctorPatientAssign) throws BusinessException, SystemException {
        LOGGER.traceEntry(doctorPatientAssign.toString());
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        Boolean result = doctorDelegate.PateintDoctorAssignDelegate(doctorPatientAssign);
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(doctorPatientAssign).setStatusCode(HttpStatusConstant.OK);
    }

    /**
     * Gets patients of doctor.
     *
     * @param doctorId the doctor id
     * @return the patients of doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @GET
    @Path("/{doctorId}/patients")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getPatientsOfDoctor(@PathParam("doctorId") int doctorId) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(doctorId));
        DoctorPatientMapper doctorPatientMapper;
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        doctorPatientMapper = doctorDelegate.getPatientsDelegate(doctorId);
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(doctorPatientMapper).setStatusCode(HttpStatusConstant.OK);
    }

    /**
     * Gets all patients of doctor.
     *
     * @return the all patients of doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @GET
    @Path("/getallpatients")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getAllPatientsOfDoctor() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        DoctorDelegate doctorDelegate = new DoctorDelegate();
        LOGGER.traceExit();
        return new ResponseEntity<>().setData(doctorDelegate.getAllPatientsDelegate()).setStatusCode(HttpStatusConstant.OK);
    }
}
