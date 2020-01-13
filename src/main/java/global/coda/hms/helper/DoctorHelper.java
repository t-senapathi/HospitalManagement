package global.coda.hms.helper;

import global.coda.hms.dao.DoctorDao;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientAssign;
import global.coda.hms.model.DoctorPatientMapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Doctor helper.
 */
public class DoctorHelper {

    /**
     * Create doctor helper doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Doctor createDoctorHelper(Doctor doctor) throws SystemException, BusinessException {
        DoctorDao doctorDao = new DoctorDao();
        try {
            doctor = doctorDao.createDoctor(doctor);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
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
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor;
        doctor = doctorDao.readDoctor(id);
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
        DoctorDao doctorDao = new DoctorDao();
        List<Doctor> doctorList;
        doctorList = doctorDao.readAllDoctor();
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
        DoctorDao doctorDao = new DoctorDao();
        try {
            doctorDao.updateDoctor(doctor);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
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
            doctorDao.deleteDoctor(id);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        return true;
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
            doctorDao.PatientDoctorAssign(newData);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        return true;
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
        DoctorDao doctorDao = new DoctorDao();
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
        DoctorDao doctorDao = new DoctorDao();
        return doctorDao.getAllPatients();
    }

}

