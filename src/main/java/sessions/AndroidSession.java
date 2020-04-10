package sessions;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Constants;
import utilities.PropertyReader;

import java.util.*;

public class AndroidSession implements SessionManager {
    private Logger logger = Logger.getLogger(AndroidSession.class);
    private PropertyReader propertyReader = new PropertyReader();
    public void startSession(){

    }

    public void startAppiumServer(){
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withIPAddress("127.0.0.1");
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
