package base;
/**
 * Love
 */

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import sessions.AndroidSession;
import sessions.IOSSession;
import sessions.SessionManager;
import utilities.EnvironmentFields;


public class BaseClass {
    protected SessionManager sessionManager;
    private Logger logger = Logger.getLogger(BaseClass.class);

    @BeforeSuite
    public void setUpTest(){
        initializeSession();
        sessionManager.startSession();
        sessionManager.initiateDriver();
    }

    @AfterSuite
    public void closeSession(){
        //sessionManager.stopSession();
    }

    public void initializeSession() {
        String platformOs = EnvironmentFields.getPlatformOs();
        logger.info("Platform OS On Which Test To Run - "+platformOs);
        if (platformOs.equalsIgnoreCase("android")) {
            sessionManager = new AndroidSession();
        }
        else if(platformOs.equalsIgnoreCase("ios"))
        {
            sessionManager = new IOSSession();
        }
    }


}
