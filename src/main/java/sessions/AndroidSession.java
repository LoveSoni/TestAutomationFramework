package sessions;

/**
 * author Love
 */

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.MobileSessionUtility;
import utilities.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AndroidSession implements SessionManager {
    private Logger logger = Logger.getLogger(AndroidSession.class);
    private AppiumDriver appiumDriver;
    private AppiumDriverLocalService appiumDriverLocalService;

    public void initiateDriver(){
        appiumDriverLocalService = startAppiumServer();
        try {
            appiumDriver = new AndroidDriver(new URL(getUrl()), clientCapabilities());
        }catch (MalformedURLException e){
            logger.error(e.getMessage());
        }
    }

    public DesiredCapabilities clientCapabilities(){
        String ANDROID_CAPABILITIES_PATH = Constants.ANDROID_CAPABILITIES_PATH;
        Map<String,String> androidProperties = PropertyReader.getAllKeysAndValues(ANDROID_CAPABILITIES_PATH);
        DesiredCapabilities desiredCapabilities = MobileSessionUtility.setCapability(androidProperties);
        return desiredCapabilities;
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
