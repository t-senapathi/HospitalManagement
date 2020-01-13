package global.coda.hms.helper;

import global.coda.hms.dao.PatientDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * The type Patient helper.
 */
public class PatientHelper {
    private static final Logger LOGGER = LogManager.getLogger(PatientHelper.class);
    /**
     * Create patient helper patient.
     *
     * @param patient the patient
     * @return the patient
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Patient createPatientHelper(Patient patient) throws SystemException, BusinessException {
        LOGGER.traceEntry(patient.toString());
        PatientDao patientDao = new PatientDao();
        try {
            patient = patientDao.createPatient(patient);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Read patient helper patient.
     *
     * @param id the id
     * @return the patient
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Patient readPatientHelper(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        PatientDao patientDao = new PatientDao();
        Patient patient;
        patient = patientDao.readPatient(id);
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Read all patient helper list.
     *
     * @return the list
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public List<Patient> readAllPatientHelper() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        PatientDao patientDao = new PatientDao();
        List<Patient> patientlist;
        patientlist = patientDao.readAllPatient();
        LOGGER.traceExit(patientlist);
        return patientlist;
    }

    /**
     * Update patient helper boolean.
     *
     * @param patient the patient
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean updatePatientHelper(Patient patient) throws SystemException, BusinessException {
        LOGGER.traceEntry(patient.toString());
        PatientDao patientDao = new PatientDao();
        try {
            patientDao.updatePatient(patient);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit("true");
        return true;
    }

    /**
     * Delete patient helper boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean deletePatientHelper(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        PatientDao patientDao = new PatientDao();
        try {
            patientDao.deletePatient(id);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit("true");
        return true;
    }
}
