package utilities;

/**
 * author Love
 */

import constants.Constants;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class SQLUtility {
    private Logger logger = Logger.getLogger(SQLUtility.class);
    private Connection connection;
    private Properties connectionProperties = PropertyReader.readProperty(Constants.ENVIRONEMENT_PROPERTIES_PATH);
    private Statement statement;

    public SQLUtility(String dbType) {
        String dbUrl = connectionProperties.getProperty(dbType + "dbUrl");
        String dbUsername = connectionProperties.getProperty(dbType + "dbUsername");
        String dbPassword = connectionProperties.getProperty(dbType + "dbPassword");
        logger.info("DB Type - " + dbType);
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();
            logger.info("DB Connection Created Successfully -");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public void closeDBConnection() {
        try {
            statement.close();
            connection.close();
            logger.info("DB Connection Closed Succesfully ");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
