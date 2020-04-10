package sessions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import constants.Constants;
import utilities.PropertyReader;

import java.net.InetAddress;
import java.util.*;

public class AndroidSession implements SessionManager {
    private Logger logger = Logger.getLogger(AndroidSession.class);
    private PropertyReader propertyReader = new PropertyReader();
    public void startSession(){

    }

    public void startAppiumServer() throws  Exception{
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        InetAddress inetAddress = InetAddress.getLocalHost();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withCapabilities(capabilities());
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,Constants.APPIUM_SERVER_LOG_LEVEL);
        appiumServiceBuilder.withIPAddress(inetAddress. getHostAddress());
        AppiumDriverLocalService appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
        logger.warn("Server started sucessfully");
    }

    @Test
    public void testMethod() throws  Exception{
        startAppiumServer();
    }

    public DesiredCapabilities capabilities(){
        String ANDROID_CAPABILITIES_PATH = Constants.ANDROID_CAPABILITIES_PATH;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Properties androidProperties = propertyReader.readProperty(ANDROID_CAPABILITIES_PATH);
        Set propertySet = androidProperties.entrySet();
        Iterator iterator = propertySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry) iterator.next();
            desiredCapabilities.setCapability(entry.getKey(),entry.getValue());
        }
        return desiredCapabilities;
    }

    public void stopSession(){

    }
}
