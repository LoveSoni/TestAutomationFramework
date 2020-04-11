package sessions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Love
 */
public class WebSession{
    private WebDriver driver;
    public void initiateDriver(){

    }

    public AppiumDriver getDriver(){
        return (AppiumDriver) this.driver;
    }

    public DesiredCapabilities clientCapabilities(){

    }

    public void startSession(){

    }

    public void stopSession(){

    }
}
