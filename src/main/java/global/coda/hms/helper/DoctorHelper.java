package global.coda.hms.helper;

import global.coda.hms.dao.DoctorDao;
import global.coda.hms.exception.*;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientAssign;
import global.coda.hms.model.DoctorPatientMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static global.coda.hms.constant.DoctorConstants.*;


/**
 * The type Doctor helper.
 */
public final class DoctorHelper {
    /**
     * This is a constructor.
     */
    private DoctorHelper() {
    }

    private static final ResourceBundle ERROR_CONSTANT = ResourceBundle.getBundle(ERROR_BUNDLE);
    private static final Logger LOGGER = LogManager.getLogger(DoctorHelper.class);

    /**
     * Create doctor helper doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public static Doctor createDoctor(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorDao doctorDao = new DoctorDao();
        try {
            if (doctor.getUsername() == null || doctor.getPassword() == null || doctor.getFirstName() == null) {
                throw new DbConstraintViolationException(ERROR_CONSTANT.getString(HM_ERROR_001));
            }
            doctor = doctorDao.createDoctor(doctor);
            if (doctor.getPkUserId() == 0) {
                throw new UserNotCreatedException(CREATE_FAILED);
            }
        } catch (DbConstraintViolationException e) {
            throw new BusinessException(e);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new BusinessException(ERROR_CONSTANT.getString(HM_ERROR_002), e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit(doctor);
        return doctor;
    }


    /**
     * Read doctor helper doctor.
     *
     * @param id the id
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public static Doctor readDoctor(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor;
        try {
            doctor = doctorDao.readDoctor(id);
            if (doctor == null) {
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_003));
            }
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);

        } catch (Exception e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit(doctor);
        return doctor;
    }


    /**
     * Read all doctor helper list.
     *
     * @return the list
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public static List<Doctor> readAllDoctor() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        DoctorDao doctorDao = new DoctorDao();
        List<Doctor> doctorList;
        try {
            doctorList = doctorDao.readAllDoctor();
            if (doctorList.size() == 0) {
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_004));
            }
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit(doctorList);
        return doctorList;
    }


    /**
     * Update doctor helper boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public static boolean updateDoctor(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorDao doctorDao = new DoctorDao();
        boolean result;
        try {
            if (doctor.getPassword() == null) {
                throw new DbConstraintViolationException(ERROR_CONSTANT.getString(HM_ERROR_005));
            }
            result = doctorDao.updateDoctor(doctor);
            if (result) {
                LOGGER.traceExit(true);
                return true;
            } else {
                return false;
            }
        } catch (UserNotFoundException | DbConstraintViolationException e) {
            throw new BusinessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

    /**
     * Delete doctor helper boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public static boolean deleteDoctor(int id) throws SystemException, BusinessException {
        DoctorDao doctorDao = new DoctorDao();
        try {
            LOGGER.traceEntry(String.valueOf(id));
            doctorDao.deleteDoctor(id);
            LOGGER.traceExit("true");
            return true;
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

    /**
     * Pateint doctor assign helper boolean.
     *
     * @param newData the new data
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public static boolean PateintDoctorAssign(DoctorPatientAssign newData) throws SystemException, BusinessException {
        DoctorDao doctorDao = new DoctorDao();
        try {
            LOGGER.traceEntry(newData.toString());
            if (newData.getDoctorId() == 0 || newData.getPatientId() == 0) {
                throw new DbConstraintViolationException(ERROR_CONSTANT.getString(HM_ERROR_006));
            }
            Boolean result = doctorDao.PatientDoctorAssign(newData);
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
     * Gets patients helper.
     *
     * @param doctorId the doctor id
     * @return the patients helper
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public static DoctorPatientMapper getPatient(int doctorId) throws BusinessException, SystemException {
        LOGGER.traceEntry(String.valueOf(doctorId));
        DoctorDao doctorDao = new DoctorDao();
        try {
            DoctorPatientMapper doctorPatientMapper = doctorDao.getPatients(doctorId);
            LOGGER.traceExit(doctorPatientMapper);
            return doctorPatientMapper;
        } catch (NoRecordFoundException e) {
            throw new BusinessException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }

    }

    /**
     * Gets all patients helper.
     *
     * @return the all patients helper
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public static Map<Integer, Doctor> getAllPatients() throws BusinessException, SystemException {
        LOGGER.traceEntry();
        try {
            DoctorDao doctorDao = new DoctorDao();
            Map<Integer, Doctor> doctorMap;
            doctorMap = doctorDao.getAllPatients();
            if (doctorMap.isEmpty()) {
                throw new NoRecordFoundException(ERROR_CONSTANT.getString(HM_ERROR_007));
            }
            LOGGER.traceExit();
            return doctorMap;
        } catch (NoRecordFoundException e) {
            throw new BusinessException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

}

