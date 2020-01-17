package global.coda.hms.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import global.coda.hms.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

import global.coda.hms.model.Patient;
import org.jetbrains.annotations.NotNull;

import static global.coda.hms.constant.PatientConstants.*;


/**
 * The Class PatientDao.
 */
public class PatientDao {
    private static final Logger LOGGER = LogManager.getLogger(PatientDao.class);
    private static final ResourceBundle SQL_CONSTANT = ResourceBundle.getBundle(SQL_BUNDLE);
    private static final ResourceBundle ERROR_CONSTANT = ResourceBundle.getBundle(ERROR_BUNDLE);
    private static final ResourceBundle INFO_CONSTANT = ResourceBundle.getBundle(INFO_BUNDLE);


    /**
     * Creates the patient.
     *
     * @param patient the patient
     * @return the patient
     * @throws Exception the exception
     */
    public Patient createPatient(Patient patient) throws Exception {
        LOGGER.traceEntry(patient.toString());
        PreparedStatement userStatement, patientStatement;
        DbConnection dbconnection = null;
        Connection connection = null;

        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(CREATE_USER),
                    Statement.RETURN_GENERATED_KEYS);
            // FIX : USE FUNCTIONS TO SET OR GET DATA
            userStatement.setString(ONE, patient.getUsername());
            userStatement.setString(TWO, patient.getPassword());
            userStatement.setInt(THREE, 1);
            userStatement.setString(FOUR, patient.getFirstName());
            userStatement.setString(FIVE, patient.getLastName());
            userStatement.setInt(SIX, patient.getAge());
            int rowsAffected = userStatement.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet keySetUser = userStatement.getGeneratedKeys();
                int userId = 0;
                if (keySetUser.next()) {
                    userId = keySetUser.getInt(ONE);
                    LOGGER.info("The generated user id is:" + userId);
                }
                patientStatement = connection.prepareStatement(
                        SQL_CONSTANT.getString(CREATE_PATIENT));
                patientStatement.setInt(ONE, userId);
                patientStatement.setInt(TWO, patient.getPatientHeight());
                patientStatement.setInt(THREE, patient.getPatientWeight());
                patientStatement.setString(FOUR, patient.getDoorNo());
                patientStatement.setString(FIVE, patient.getStreet());
                patientStatement.setString(SIX, patient.getCity());
                patientStatement.setString(SEVEN, patient.getBloodGroup());
                int rowsAffectedPatient = patientStatement.executeUpdate();
                if (rowsAffectedPatient != 0) {
                    connection.commit();
                    patient.setPkUserId(userId);
                    LOGGER.info(INFO_CONSTANT.getString(CREATE_SUCCESS));
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            connection.rollback();
            throw new SQLIntegrityConstraintViolationException(ERROR_CONSTANT.getString(HM_ERROR_002), e);
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Delete patient.
     *
     * @param id the id
     * @return true, if successful
     * @throws UserNotFoundException the user not found exception
     * @throws Exception             the exception
     */
    public boolean deletePatient(int id) throws UserNotFoundException, Exception {
        LOGGER.traceEntry(String.valueOf(id));
        DbConnection dbconnection = null;
        Connection connection = null;
        PreparedStatement userStatement, patientStatement;
        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(DELETE_USER),
                    Statement.RETURN_GENERATED_KEYS);
            userStatement.setInt(ONE, id);
            int rowsAffected = userStatement.executeUpdate();
            if (rowsAffected == 1) {
                patientStatement = connection.prepareStatement(SQL_CONSTANT.getString(DELETE_PATIENT));
                patientStatement.setInt(ONE, id);
                int rowsAffectedPatient = patientStatement.executeUpdate();
                if (rowsAffectedPatient == 1) {
                    connection.commit();
                    LOGGER.info(INFO_CONSTANT.getString(DELETE_SUCCESS));
                    LOGGER.traceExit("true");
                    return true;
                } else {
                    connection.rollback();
                    throw new UserNotFoundException();
                }
            } else {
                connection.rollback();
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_003));
            }

        }  finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
    }

    /**
     * Read all patient.
     *
     * @return the list
     * @throws Exception the exception
     */
    public List<Patient> readAllPatient() throws Exception {
        LOGGER.traceEntry();
        DbConnection dbconnection = null;
        Connection connection = null;
        ResultSet resultSet;
        PreparedStatement userStatement;
        Patient patient;
        List<Patient> patientlist = new ArrayList<>();
        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            userStatement = connection
                    .prepareStatement(SQL_CONSTANT.getString(READ_ALL_PATIENT));
            resultSet = userStatement.executeQuery();
            while (resultSet.next()) {
                patient = createPatientObject(resultSet);
                patientlist.add(patient);
            }
            LOGGER.info(INFO_CONSTANT.getString(READALL_SUCCESS));
            LOGGER.traceExit(patientlist);
            return patientlist;

        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
    }

    /**
     *
     * @param resultSet contains all fetched rows
     * @return patient object
     * @throws SQLException the sql Exception
     */
    @NotNull
    private Patient createPatientObject(ResultSet resultSet) throws SQLException {
        Patient patient;
        patient = new Patient();
        patient.setUsername(resultSet.getString(USERNAME));
        patient.setPassword(resultSet.getString(PASSWORD));
        patient.setPkUserId(resultSet.getInt(USER_ID));
        patient.setFkRoleId(resultSet.getInt(ROLE));
        patient.setFirstName(resultSet.getString(FIRST_NAME));
        patient.setLastName(resultSet.getString(LAST_NAME));
        patient.setAge(resultSet.getInt(AGE));
        patient.setPkPatientId(resultSet.getInt(PATIENT_ID));
        patient.setPatientHeight(resultSet.getInt(PATIENT_HEIGHT));
        patient.setPatientWeight(resultSet.getInt(PATIENT_WEIGHT));
        patient.setDoorNo(resultSet.getString(DOOR_NO));
        patient.setStreet(resultSet.getString(STREET));
        patient.setCity(resultSet.getString(CITY));
        patient.setBloodGroup(resultSet.getString(BLOOD_GROUP));
        return patient;
    }

    /**
     * Read patient.
     *
     * @param id the id
     * @return the patient
     * @throws Exception the exception
     */
    public Patient readPatient(int id) throws Exception {
        LOGGER.traceEntry(String.valueOf(id));
        DbConnection dbconnection = null;
        Connection connection = null;
        ResultSet resultSet;
        PreparedStatement userStatement;
        Patient patient = null;
        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(READ_PATIENT));
            userStatement.setInt(ONE, id);
            resultSet = userStatement.executeQuery();
            if (resultSet.next()) {
                patient = createPatientObject(resultSet);
                LOGGER.info(INFO_CONSTANT.getString(READ_SUCCESS));
            }

        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
        LOGGER.traceExit(patient);
        return patient;
    }


    /**
     * Update patient.
     *
     * @param newData the newData
     * @return true, if successful
     * @throws UserNotFoundException the user not found exception
     * @throws Exception             the exception
     */
    public boolean updatePatient(Patient newData) throws UserNotFoundException, Exception {
        LOGGER.traceEntry();
        DbConnection dbConnection = null;
        Connection connection = null;
        PreparedStatement userStatement, patientStatement;
        try {
            dbConnection = new DbConnection();
            connection = dbConnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(UPDATE_USER));
            userStatement.setString(ONE, newData.getPassword());
            userStatement.setInt(TWO, newData.getAge());
            userStatement.setInt(THREE, newData.getPkUserId());
            int rowsAffected = userStatement.executeUpdate();
            if (rowsAffected == 1) {
                patientStatement = connection.prepareStatement(SQL_CONSTANT.getString(UPDATE_PATIENT));
                patientStatement.setInt(ONE, newData.getPatientHeight());
                patientStatement.setInt(TWO, newData.getPatientWeight());
                patientStatement.setInt(THREE, newData.getPkUserId());
                int rowsAffectedPatient = patientStatement.executeUpdate();
                if (rowsAffectedPatient == 1) {
                    connection.commit();
                    LOGGER.info(INFO_CONSTANT.getString(UPDATE_SUCCESS));
                    LOGGER.traceExit("true");
                    return true;
                } else {
                    throw new UserNotFoundException();
                }
            } else {
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_003));
            }

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (connection != null) {
                dbConnection.closeConnection();

            }
        }
    }


}
