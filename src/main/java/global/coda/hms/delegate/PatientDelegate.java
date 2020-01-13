package global.coda.hms.delegate;

import global.coda.hms.helper.PatientHelper;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * The type Patient delegate.
 */
public class PatientDelegate {
    private static final Logger LOGGER = LogManager.getLogger(PatientDelegate.class);
    /**
     * Create patient delegate patient.
     *
     * @param patient the patient
     * @return the patient
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Patient createPatientDelegate(Patient patient) throws SystemException, BusinessException {
        LOGGER.traceEntry(patient.toString());
        PatientHelper patientHelper = new PatientHelper();
        patient = patientHelper.createPatientHelper(patient);
        LOGGER.traceExit(patient);
        return patient;
    }


    /**
     * Read patient delegate patient.
     *
     * @param id the id
     * @return the patient
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Patient readPatientDelegate(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        PatientHelper patientHelper = new PatientHelper();
        Patient patient;
        patient = patientHelper.readPatientHelper(id);
        LOGGER.traceExit(patient);
        return patient;
    }


    /**
     * Read all patient delegate list.
     *
     * @return the list
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public List<Patient> readAllPatientDelegate() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        PatientHelper patientHelper = new PatientHelper();
        List<Patient> patientlist;
        patientlist = patientHelper.readAllPatientHelper();
        LOGGER.traceExit(patientlist);
        return patientlist;
    }


    /**
     * Update patient delegate boolean.
     *
     * @param patient the patient
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean updatePatientDelegate(Patient patient) throws SystemException, BusinessException {
        LOGGER.traceEntry(patient.toString());
        PatientHelper patientHelper = new PatientHelper();
        patientHelper.updatePatientHelper(patient);
        LOGGER.traceExit("true");
        return true;
    }


    /**
     * Delete patient delegate boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean deletePatientDelegate(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        PatientHelper patientHelper = new PatientHelper();
        patientHelper.deletePatientHelper(id);
        LOGGER.traceExit("true");
        return true;
    }
}
