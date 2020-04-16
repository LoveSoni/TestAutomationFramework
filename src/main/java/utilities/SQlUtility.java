package utilities;

/**
 * Love
 */

import constants.Constants;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.Properties;

public class SQlUtility {
    private Logger logger = Logger.getLogger(SQlUtility.class);
    private Properties connectionProperties = PropertyReader.readProperty(Constants.ENVIRONEMENT_PROPERTIES_PATH);

    public SQlUtility(String dbType) {
        String dbUrl =  connectionProperties.getProperty(dbType+"dbUrl");
        String dbUsername = connectionProperties.getProperty(dbType+"dbUsername");
        String dbPassword = connectionProperties.getProperty(dbType+"dbPassword");
        logger.info("DB Type - "+dbType);
        try {
            DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            logger.info("DB Connection Created Successfully -");
        }catch (SQLException e)
        {
            logger.error(e.getMessage());
        }
    }
}
