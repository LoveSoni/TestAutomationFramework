package utilities;

import org.apache.log4j.Logger;

public class LogUtility {
    private Logger logger;

    public LogUtility(Class clasName) {
        logger = Logger.getLogger(clasName);
    }


}
