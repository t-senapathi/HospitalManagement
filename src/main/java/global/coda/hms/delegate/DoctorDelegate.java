package global.coda.hms.delegate;


import global.coda.hms.helper.DoctorHelper;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientAssign;
import global.coda.hms.model.DoctorPatientMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Doctor delegate.
 */
public class DoctorDelegate {
    private static final Logger LOGGER = LogManager.getLogger(DoctorDelegate.class);

    /**
     * Create doctor delegate doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Doctor createDoctorDelegate(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorHelper doctorHelper = new DoctorHelper();

        doctor = doctorHelper.createDoctorHelper(doctor);
        LOGGER.traceExit(doctor);
        return doctor;
    }


    /**
     * Read doctor delegate doctor.
     *
     * @param id the id
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Doctor readDoctorDelegate(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        DoctorHelper doctorHelper = new DoctorHelper();
        Doctor doctor;
        doctor = doctorHelper.readDoctorHelper(id);
        LOGGER.traceExit(doctor);
        return doctor;
    }


    /**
     * Read all doctor delegate list.
     *
     * @return the list
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public List<Doctor> readAllDoctorDelegate() throws SystemException, BusinessException {
        LOGGER.traceEntry();
        DoctorHelper doctorHelper = new DoctorHelper();
        List<Doctor> doctorlist;
        doctorlist = doctorHelper.readAllDoctorHelper();
        LOGGER.traceEntry();
        return doctorlist;
    }


    /**
     * Update doctor delegate boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean updateDoctorDelegate(Doctor doctor) throws SystemException, BusinessException {
        LOGGER.traceEntry(doctor.toString());
        DoctorHelper doctorHelper = new DoctorHelper();
        doctorHelper.updateDoctorHelper(doctor);
        LOGGER.traceExit("true");
        return true;
    }

    /**
     * Delete doctor delegate boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean deleteDoctorDelegate(int id) throws SystemException, BusinessException {
        LOGGER.traceEntry(String.valueOf(id));
        DoctorHelper doctorHelper = new DoctorHelper();
        doctorHelper.deleteDoctorHelper(id);
        LOGGER.traceExit("true");
        return true;
    }

    /**
     * Pateint doctor assign delegate boolean.
     *
     * @param newData the new data
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public boolean PateintDoctorAssignDelegate(DoctorPatientAssign newData) throws SystemException, BusinessException {
        LOGGER.traceEntry(newData.toString());
        DoctorHelper doctorHelper = new DoctorHelper();
        doctorHelper.PateintDoctorAssignHelper(newData);
        LOGGER.traceExit("true");
        return true;
    }

    /**
     * Gets patients delegate.
     *
     * @param doctorId the doctor id
     * @return the patients delegate
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public DoctorPatientMapper getPatientsDelegate(int doctorId) throws BusinessException, SystemException {
        LOGGER.traceEntry(String.valueOf(doctorId));
        DoctorHelper doctorHelper = new DoctorHelper();
        LOGGER.traceExit();
        return doctorHelper.getPatientsHelper(doctorId);
    }

    /**
     * Gets all patients delegate.
     *
     * @return the all patients delegate
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public List<Doctor> getAllPatientsDelegate() throws BusinessException, SystemException {
        LOGGER.traceEntry();
        DoctorHelper doctorHelper = new DoctorHelper();
        List<Doctor> doctorList = new ArrayList<>();
        Map<Integer, Doctor> doctorMap;
        doctorMap = doctorHelper.getAllPatientsHelper();
        for (Map.Entry<Integer, Doctor> entry : doctorMap.entrySet()) {
            doctorList.add(entry.getValue());
        }
        LOGGER.traceExit(doctorList);
        return doctorList;
    }

}

