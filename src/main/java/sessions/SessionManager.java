package sessions;

import constants.Constants;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.PropertyReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public interface SessionManager {

    public void initiateDriver();

    public void stopSession();


    default AppiumDriverLocalService startAppiumServer(){
        AppiumDriverLocalService appiumDriverLocalService = null;
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        InetAddress inetAddress  = null;
        try {
             inetAddress  = InetAddress.getLocalHost();
        }catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,Constants.APPIUM_SERVER_LOG_LEVEL);
        appiumServiceBuilder.withIPAddress(inetAddress.getHostAddress());
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
        return appiumDriverLocalService;
    }

    default DesiredCapabilities setCapability(Map<String,String> keysAndValues){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Set propertySet = keysAndValues.entrySet();
        Iterator iterator = propertySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry) iterator.next();
            desiredCapabilities.setCapability(entry.getKey(),entry.getValue());
        }
        return desiredCapabilities;
    }

    default DesiredCapabilities capabilities(){
        String ANDROID_CAPABILITIES_PATH = Constants.ANDROID_CAPABILITIES_PATH;
        Map<String,String> androidProperties = PropertyReader.getAllKeysAndValues(ANDROID_CAPABILITIES_PATH);
        DesiredCapabilities desiredCapabilities = setCapability(androidProperties);
        return desiredCapabilities;
    }

}
