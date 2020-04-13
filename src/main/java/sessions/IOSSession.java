package sessions;

/**
 * Love
 */

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.MobileSessionUtility;
import utilities.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class IOSSession implements SessionManager {
    private AppiumDriver appiumDriver;
    private Logger logger = org.apache.log4j.Logger.getLogger(IOSSession.class);
    private AppiumDriverLocalService appiumDriverLocalService;

    @Override
    public void startSession(){
        logger.info("Appium Server Started Successfully");
        appiumDriverLocalService = startAppiumServer();
    }
    @Override
    public void initiateDriver(){
        appiumDriverLocalService = startAppiumServer();
        try {
            appiumDriver = new IOSDriver(new URL(getUrl()), clientCapabilities());
        }catch (MalformedURLException e)
        {
            logger.error(e.getMessage());
        }

    }

    public DesiredCapabilities clientCapabilities(){
        String ANDROID_CAPABILITIES_PATH = Constants.IOS_CAPABILITIES_PATH;
        Map<String,String> androidProperties = PropertyReader.getAllKeysAndValues(ANDROID_CAPABILITIES_PATH);
        DesiredCapabilities desiredCapabilities = MobileSessionUtility.setCapability(androidProperties);
        return desiredCapabilities;
    }

    public String getUrl(){
        return this.getUrl().toString();
    }

    @Override
    public AppiumDriver getDriver(){
        return this.appiumDriver;
    }

    @Override
    public void stopSession(){

    }
}
