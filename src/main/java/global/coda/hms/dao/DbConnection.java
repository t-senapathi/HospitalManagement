package global.coda.hms.dao;

import global.coda.hms.exception.SystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Db connection.
 */
public class DbConnection {
    /**
     * The Connection.
     */
    private Connection connection;
    private static final Logger LOGGER = LogManager.getLogger(PatientDao.class);

    /**
     * Gets connection.
     *
     * @return the connection
     * @throws SystemException the system exception
     */
    public Connection getConnection() throws SystemException {
        LOGGER.traceEntry();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
            return connection;
        } catch (SQLException e) {
            throw new SystemException("DB Connection Failed");
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            LOGGER.traceExit();
        }
    }

    /**
     * Close connection.
     *
     * @throws SystemException the system exception
     */
    public void closeConnection() throws SystemException {
        LOGGER.traceEntry();
        try {
            connection.close();
        } catch (SQLException e) {
            throw new SystemException("DB Close failed", e);
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            LOGGER.traceExit();
        }
    }
}
