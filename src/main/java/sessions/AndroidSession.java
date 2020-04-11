package sessions;

/**
 * author Love
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSession implements SessionManager {
    private Logger logger = Logger.getLogger(AndroidSession.class);
    private AppiumDriver appiumDriver;
    private AppiumDriverLocalService appiumDriverLocalService;

    public void initiateDriver(){
        appiumDriverLocalService = startAppiumServer();
        try {
            appiumDriver = new AndroidDriver(new URL(getUrl()), capabilities());
        }catch (MalformedURLException e){
            logger.error(e.getMessage());
        }
    }

    public AppiumDriver getDriver()
    {
        return this.appiumDriver;
    }

    public String getUrl(){
        return appiumDriverLocalService.getUrl().toString();
    }

    public void stopSession(){
        logger.info("Appium Server is getting closed");
        appiumDriverLocalService.stop();
    }
}
