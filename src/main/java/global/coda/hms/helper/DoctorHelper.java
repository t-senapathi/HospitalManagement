package global.coda.hms.helper;

import global.coda.hms.dao.DoctorDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientAssign;
import global.coda.hms.model.DoctorPatientMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * The type Doctor helper.
 */
public class DoctorHelper {
    private static final Logger LOGGER = LogManager.getLogger(DoctorHelper.class);
    /**
     * Create doctor helper doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Doctor createDoctorHelper(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorDao doctorDao = new DoctorDao();
        try {
            doctor = doctorDao.createDoctor(doctor);
        } catch (SQLException e) {
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
    public Doctor readDoctorHelper(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor;
        doctor = doctorDao.readDoctor(id);
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
    public List<Doctor> readAllDoctorHelper() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        DoctorDao doctorDao = new DoctorDao();
        List<Doctor> doctorList;
        doctorList = doctorDao.readAllDoctor();
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
    public boolean updateDoctorHelper(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorDao doctorDao = new DoctorDao();
        try {
            doctorDao.updateDoctor(doctor);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit("true");
        return true;
    }

    /**
     * Delete doctor helper boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean deleteDoctorHelper(int id) throws SystemException, BusinessException {
        DoctorDao doctorDao = new DoctorDao();
        try {
            LOGGER.traceEntry(String.valueOf(id));
            LOGGER.traceExit("true");
            return doctorDao.deleteDoctor(id);
        } catch (SQLException e) {
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
    public boolean PateintDoctorAssignHelper(DoctorPatientAssign newData) throws SystemException, BusinessException {
        DoctorDao doctorDao = new DoctorDao();
        try {
            LOGGER.traceEntry(newData.toString());
            LOGGER.traceExit("true");
            return doctorDao.PatientDoctorAssign(newData);
        } catch (SQLException e) {
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
    public DoctorPatientMapper getPatientsHelper(int doctorId) throws BusinessException, SystemException {
        LOGGER.traceEntry(String.valueOf(doctorId));
        DoctorDao doctorDao = new DoctorDao();
        LOGGER.traceExit();
        return doctorDao.getPatients(doctorId);
    }

    /**
     * Gets all patients helper.
     *
     * @return the all patients helper
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public Map<Integer, Doctor> getAllPatientsHelper() throws BusinessException, SystemException {
        LOGGER.traceEntry();
        DoctorDao doctorDao = new DoctorDao();
        LOGGER.traceExit();
        return doctorDao.getAllPatients();
    }

}

