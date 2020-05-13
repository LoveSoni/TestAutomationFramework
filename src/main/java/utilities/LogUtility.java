package utilities;

import org.apache.log4j.Logger;

public class LogUtility {
    private Logger logger;

    public LogUtility(Class clasName) {
        logger = Logger.getLogger(clasName);
    }

    public void logInfo(String logMsg){
        logger.info(logMsg);
    }

    public void logWarn(String logMsg){
        logger.warn(logMsg);
    }


}
