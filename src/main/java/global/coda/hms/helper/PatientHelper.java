package global.coda.hms.helper;

import global.coda.hms.dao.PatientDao;
import global.coda.hms.exception.*;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ResourceBundle;

import static global.coda.hms.constant.PatientConstants.*;

/**
 * The type Patient helper.
 */
public class PatientHelper {
    private static final Logger LOGGER = LogManager.getLogger(PatientHelper.class);
    private static final ResourceBundle ERROR_CONSTANT = ResourceBundle.getBundle(ERROR_BUNDLE);

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
            if (patient.getUsername() == null || patient.getPassword() == null || patient.getFirstName() == null) {
                throw new DbConstraintViolationException(ERROR_CONSTANT.getString(HM_ERROR_001));
            }
            patient = patientDao.createPatient(patient);
            if (patient.getPkUserId() == 0) {
                throw new UserNotCreatedException(CREATE_FAILED);
            }
        } catch (DbConstraintViolationException | SQLIntegrityConstraintViolationException e) {
            throw new BusinessException(e);
        } catch (UserNotCreatedException | SQLException e) {
            //FIX : USE CUSTOM MESSAGES
            throw new SystemException(e);
        } catch (Exception e) {
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
        try {
            patient = patientDao.readPatient(id);
            if (patient == null) {
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_003));
            }
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);

        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            throw new SystemException(e);

        }
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
        try {
            patientlist = patientDao.readAllPatient();
            if (patientlist.isEmpty()) {
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_004));
            }
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
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
            if (patient.getPassword() == null) {
                throw new DbConstraintViolationException(ERROR_CONSTANT.getString(HM_ERROR_005));
            }
            boolean result = patientDao.updatePatient(patient);
            LOGGER.traceExit("true");
            return result;
        } catch (UserNotFoundException | DbConstraintViolationException e) {
            throw new BusinessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
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
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit("true");
        return true;
    }
}
