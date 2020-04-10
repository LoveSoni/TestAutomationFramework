package sessions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSSession implements SessionManager {
    private AppiumDriver appiumDriver;
    private Logger logger = org.apache.log4j.Logger.getLogger(IOSSession.class);
    private AppiumDriverLocalService appiumDriverLocalService;

    @Override
    public void initiateDriver(){
        appiumDriverLocalService = startAppiumServer();
        try {
            appiumDriver = new IOSDriver(new URL(getUrl()), capabilities());
        }catch (MalformedURLException e)
        {
            logger.error(e.getMessage());
        }

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
