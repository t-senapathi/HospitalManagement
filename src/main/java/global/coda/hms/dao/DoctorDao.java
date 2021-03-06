package global.coda.hms.dao;

import java.sql.*;
import java.util.*;

import global.coda.hms.constant.PatientConstants;
import global.coda.hms.exception.*;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientAssign;
import global.coda.hms.model.DoctorPatientMapper;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import static global.coda.hms.constant.DoctorConstants.*;

/**
 * The type Doctor dao.
 */
public class DoctorDao {
    private static final Logger LOGGER = LogManager.getLogger(DoctorDao.class);
    private static final ResourceBundle SQL_CONSTANT = ResourceBundle.getBundle(SQL_BUNDLE);
    private static final ResourceBundle ERROR_CONSTANT = ResourceBundle.getBundle(ERROR_BUNDLE);
    private static final ResourceBundle INFO_CONSTANT = ResourceBundle.getBundle(INFO_BUNDLE);


    /**
     * Create doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     * @throws Exception the exception
     */
    public Doctor createDoctor(Doctor doctor) throws Exception {
        LOGGER.traceEntry(doctor.toString());
        PreparedStatement userStatement, doctorStatement;
        DbConnection dbconnection = null;
        Connection connection = null;

        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(CREATE_USER),
                    Statement.RETURN_GENERATED_KEYS);
            userStatement.setString(ONE, doctor.getUsername());
            userStatement.setString(TWO, doctor.getPassword());
            userStatement.setInt(THREE, 2);
            userStatement.setString(FOUR, doctor.getFirstName());
            userStatement.setString(FIVE, doctor.getLastName());
            userStatement.setInt(SIX, doctor.getAge());
            int rowsAffected = userStatement.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet keySetUser = userStatement.getGeneratedKeys();
                int userId = 0;
                if (keySetUser.next()) {
                    userId = keySetUser.getInt(ONE);
                    LOGGER.info(userId);
                }
                doctorStatement = connection.prepareStatement(SQL_CONSTANT.getString(CREATE_DOCTOR));
                doctorStatement.setInt(ONE, userId);
                doctorStatement.setString(TWO, doctor.getSpecialisation());
                doctorStatement.setInt(THREE, doctor.getExperience());
                int rowsAffectedDoctor = doctorStatement.executeUpdate();
                if (rowsAffectedDoctor == 1) {
                    connection.commit();
                    doctor.setPkUserId(userId);
                    LOGGER.info(INFO_CONSTANT.getString(CREATE_SUCCESS));
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }

        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
        LOGGER.traceExit(doctor);
        return doctor;
    }

    /**
     * Read doctor doctor.
     *
     * @param id the id
     * @return the doctor
     * @throws Exception the exception
     */
    public Doctor readDoctor(int id) throws Exception {
        LOGGER.traceEntry(String.valueOf(id));
        DbConnection dbconnection = null;
        Connection connection = null;
        ResultSet resultSet;
        PreparedStatement userStatement;
        Doctor doctor = null;
        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(READ_DOCTOR));
            userStatement.setInt(ONE, id);
            resultSet = userStatement.executeQuery();
            if (resultSet.next()) {
                doctor = createDoctorObject(resultSet);
                LOGGER.info(INFO_CONSTANT.getString(READ_SUCCESS));
            }

        } catch (Exception e) {
            throw new SystemException(e);

        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
        LOGGER.traceExit(doctor);
        return doctor;
    }

    /**
     * Read all doctor list.
     *
     * @return the list
     * @throws Exception the exception
     */
    public List<Doctor> readAllDoctor() throws Exception {
        DbConnection dbconnection = null;
        Connection connection = null;
        ResultSet resultSet;
        PreparedStatement userStatement;
        List<Doctor> doctorlist = new ArrayList<>();
        Doctor doctor;
        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(READ_ALL_DOCTOR));
            resultSet = userStatement.executeQuery();
            while (resultSet.next()) {
                doctor = createDoctorObject(resultSet);
                doctorlist.add(doctor);
            }
            LOGGER.info(INFO_CONSTANT.getString(READALL_SUCCESS));
            LOGGER.traceExit(doctorlist);
            return doctorlist;

        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
    }

    /**
     * @param resultSet contains all fetched rows
     * @return doctor object
     * @throws SQLException the SQL exception
     */
    @NotNull
    private Doctor createDoctorObject(ResultSet resultSet) throws SQLException {
        Doctor doctor;
        doctor = new Doctor();
        doctor.setUsername(resultSet.getString(USERNAME));
        doctor.setPassword(resultSet.getString(PASSWORD));
        doctor.setPkUserId(resultSet.getInt(USER_ID));
        doctor.setFkRoleId(resultSet.getInt(ROLE));
        doctor.setFirstName(resultSet.getString(FIRST_NAME));
        doctor.setLastName(resultSet.getString(LAST_NAME));
        doctor.setAge(resultSet.getInt(AGE));
        doctor.setPkDoctorId(resultSet.getInt(DOCTOR_ID));
        doctor.setSpecialisation(resultSet.getString(SPECIALISATION));
        doctor.setExperience(resultSet.getInt(EXPERIENCE));
        return doctor;
    }


    /**
     * Update doctor boolean.
     *
     * @param newData the new data
     * @return the boolean
     * @throws UserNotFoundException the user not found exception
     * @throws Exception             the exception
     */
    public boolean updateDoctor(Doctor newData) throws UserNotFoundException, Exception {
        LOGGER.traceEntry(newData.toString());
        DbConnection dbConnection = null;
        Connection connection = null;
        PreparedStatement userStatement, doctorStatement;
        try {
            dbConnection = new DbConnection();
            connection = dbConnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(UPDATE_USER),
                    Statement.RETURN_GENERATED_KEYS);
            userStatement.setString(ONE, newData.getPassword());
            userStatement.setInt(TWO, newData.getAge());
            userStatement.setInt(THREE, newData.getPkUserId());
            int rowsAffected = userStatement.executeUpdate();
            if (rowsAffected == 1) {
                doctorStatement = connection.prepareStatement(SQL_CONSTANT.getString(UPDATE_DOCTOR));
                doctorStatement.setString(ONE, newData.getSpecialisation());
                doctorStatement.setInt(TWO, newData.getExperience());
                doctorStatement.setInt(THREE, newData.getPkUserId());
                int rowsAffectedDoctor = doctorStatement.executeUpdate();
                if (rowsAffectedDoctor == 1) {
                    connection.commit();
                    LOGGER.info(INFO_CONSTANT.getString(UPDATE_SUCCESS));
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

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (connection != null) {
                dbConnection.closeConnection();
            }
        }
    }


    /**
     * Delete doctor boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws UserNotFoundException the user not found exception
     * @throws Exception             the exception
     */
    public boolean deleteDoctor(int id) throws UserNotFoundException, Exception {
        LOGGER.traceEntry(String.valueOf(id));
        DbConnection dbconnection = null;
        Connection connection = null;
        PreparedStatement userStatement, doctorStatement;
        try {
            dbconnection = new DbConnection();
            connection = dbconnection.getConnection();
            connection.setAutoCommit(false);
            userStatement = connection.prepareStatement(SQL_CONSTANT.getString(DELETE_USER),
                    Statement.RETURN_GENERATED_KEYS);
            userStatement.setInt(ONE, id);
            int rowsAffected = userStatement.executeUpdate();
            if (rowsAffected == 1) {
                doctorStatement = connection.prepareStatement(SQL_CONSTANT.getString(DELETE_DOCTOR));
                doctorStatement.setInt(ONE, id);
                int rowsAffectedDoctor = doctorStatement.executeUpdate();
                if (rowsAffectedDoctor == 1) {
                    connection.commit();
                    LOGGER.info(INFO_CONSTANT.getString(DELETE_SUCCESS));
                    LOGGER.traceExit("true");
                    return true;
                } else {
                    connection.rollback();
                    throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_003));
                }
            } else {
                connection.rollback();
                throw new UserNotFoundException(ERROR_CONSTANT.getString(HM_ERROR_003));
            }

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (connection != null) {
                dbconnection.closeConnection();
            }
        }
    }

    /**
     * Patient doctor assign boolean.
     *
     * @param newData the new data
     * @return the boolean
     * @throws UserNotFoundException the user not found exception
     * @throws Exception             the exception
     */
    public boolean PatientDoctorAssign(DoctorPatientAssign newData) throws UserNotFoundException, Exception {
        LOGGER.traceEntry(newData.toString());
        DbConnection dbConnection = null;
        Connection connection = null;
        PreparedStatement assignStatement;
        try {
            dbConnection = new DbConnection();
            connection = dbConnection.getConnection();
            connection.setAutoCommit(false);
            assignStatement = connection.prepareStatement(SQL_CONSTANT.getString(PATIENT_DOCTOR_ASSIGN),
                    Statement.RETURN_GENERATED_KEYS);
            assignStatement.setInt(ONE, newData.getPatientId());
            assignStatement.setInt(TWO, newData.getDoctorId());
            assignStatement.setString(THREE, newData.getDisease());
            int rowsAffected = assignStatement.executeUpdate();

            if (rowsAffected == 1) {
                connection.commit();
                LOGGER.info(INFO_CONSTANT.getString(UPDATE_SUCCESS));
                LOGGER.traceExit("true");
                return true;
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

    /**
     * Gets patients.
     *
     * @param doctorId the doctor id
     * @return the patients
     * @throws NoRecordFoundException the no record found exception
     * @throws Exception              the exception
     */
    public DoctorPatientMapper getPatients(int doctorId) throws NoRecordFoundException, Exception {
        LOGGER.traceEntry(String.valueOf(doctorId));
        DoctorPatientMapper doctorPatientMapper = new DoctorPatientMapper();
        DbConnection dbConnection = null;
        PreparedStatement preparedStatement;
        Connection connection = null;
        PatientDao patientDao = new PatientDao();
        try {
            dbConnection = new DbConnection();
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CONSTANT.getString(GET_PATIENT),
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(ONE, doctorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DoctorPatientAssign> doctorPatientAssigns = new ArrayList<>();
            while (resultSet.next()) {
                DoctorPatientAssign doctorPatientAssign = new DoctorPatientAssign();
                doctorPatientAssign.setDoctorId(resultSet.getInt("fk_doctor_id"));
                doctorPatientAssign.setPatientId(resultSet.getInt("fk_patient_id"));
                doctorPatientAssign.setDisease(resultSet.getString("disease"));
                doctorPatientAssigns.add(doctorPatientAssign);
            }
            if (doctorPatientAssigns.size() == 0) {
                throw new NoRecordFoundException(ERROR_CONSTANT.getString(HM_ERROR_007));
            }
            doctorPatientMapper.setDoctorId(doctorId);
            List<Patient> patients = new ArrayList<>();
            for (DoctorPatientAssign assign : doctorPatientAssigns) {
                Patient patient = patientDao.readPatient(assign.getPatientId());
                patients.add(patient);
            }
            doctorPatientMapper.setPatients(patients);
            LOGGER.traceExit(doctorPatientMapper);
            return doctorPatientMapper;
        } finally {
            if (connection != null) {
                dbConnection.closeConnection();
            }
        }
    }

    /**
     * Gets all patients.
     *
     * @return the all patients
     * @throws Exception the exception
     */
    public Map<Integer, Doctor> getAllPatients() throws Exception {
        LOGGER.traceEntry();
        DbConnection dbConnection = null;
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            dbConnection = new DbConnection();
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(SQL_CONSTANT.getString(GET_ALL_PATIENT));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Patient> patientList;
            Map<Integer, Doctor> doctorMap = new HashMap<>();
            Doctor doctor;
            Patient patient;
            while (resultSet.next()) {
                doctor = new Doctor();
                patient = new Patient();
                doctor.setPkUserId(resultSet.getInt(FK_DOCTOR_ID));
                patient.setPkUserId(resultSet.getInt(FK_PATIENT_ID));
                patient.setUsername(resultSet.getString(USERNAME));
                patient.setFkRoleId(resultSet.getInt(ROLE));
                patient.setAge(resultSet.getInt(AGE));
                patient.setStreet(resultSet.getString(PatientConstants.STREET));
                patient.setCity(resultSet.getString(PatientConstants.CITY));
                patient.setDoorNo(resultSet.getString(PatientConstants.DOOR_NO));
                if (!doctorMap.containsKey(doctor.getPkUserId())) {
                    patientList = new ArrayList<>();
                    patientList.add(patient);
                    doctor.setPatientList(patientList);
                    doctorMap.put(doctor.getPkUserId(), doctor);
                } else {
                    doctor = doctorMap.get(doctor.getPkUserId());
                    patientList = doctor.getPatientList();
                    patientList.add(patient);
                    // doctor.setPatientList(patientList);
                    // doctorMap.put(doctor.getPkUserId(), doctor);
                }
            }
            LOGGER.traceExit(doctorMap);
            return doctorMap;
        } finally {
            if (connection != null) {
                dbConnection.closeConnection();
            }
        }
    }
}
