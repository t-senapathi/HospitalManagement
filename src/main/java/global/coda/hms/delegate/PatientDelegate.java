package global.coda.hms.delegate;

import global.coda.hms.helper.PatientHelper;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;

import java.util.List;

/**
 * The type Patient delegate.
 */
public class PatientDelegate {

    /**
     * Create patient delegate patient.
     *
     * @param patient the patient
     * @return the patient
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    public Patient createPatientDelegate(Patient patient) throws SystemException, BusinessException {
        PatientHelper patientHelper = new PatientHelper();
        patient = patientHelper.createPatientHelper(patient);
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
        PatientHelper patientHelper = new PatientHelper();
        Patient patient;
        patient = patientHelper.readPatientHelper(id);
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
        PatientHelper patientHelper = new PatientHelper();
        List<Patient> patientlist;
        patientlist = patientHelper.readAllPatientHelper();
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
        PatientHelper patientHelper = new PatientHelper();
        patientHelper.updatePatientHelper(patient);
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
        PatientHelper patientHelper = new PatientHelper();
        patientHelper.deletePatientHelper(id);
        return true;
    }
}
