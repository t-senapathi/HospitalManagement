package global.coda.hms.dao;

import constant.PatientTestConstants;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserNotFoundException;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PatientDaoTest {
    private static final Logger LOGGER = LogManager.getLogger(PatientDaoTest.class);
    @Test
    public void readPatientTestValidId() {
        try {
            PatientDao patientDao = new PatientDao();
            Patient patient = patientDao.readPatient(PatientTestConstants.validId);
            LOGGER.info(patient.toString());
            assertEquals(patient.getFirstName(), PatientTestConstants.validfirstname);
        } catch (BusinessException | SystemException e) {
            //LOGGER.error(e.getMessage());
        }
    }
    @Test(expectedExceptions = {BusinessException.class })
    public void readPatientTestInvalidId() {
            PatientDao patientDao = new PatientDao();
        try {
            Patient patient = patientDao.readPatient(PatientTestConstants.validId);
        } catch (BusinessException | SystemException e) {
           // e.printStackTrace();
        }
    }
    @Test
    public void createPatientTestValidUsername() {
        try {
            PatientDao patientDao = new PatientDao();
            Patient patient=patientDao.createPatient(PatientTestConstants.getPatient());
            assertEquals(patient.getUsername(),PatientTestConstants.newusername);
        } catch (Exception error) {

        }
    }
}