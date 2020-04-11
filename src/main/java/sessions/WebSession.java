package sessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Love
 */
public class WebSession{
    private WebDriver driver;
    private WebDriverManager webDriverManager;

    public void initiateDriver(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){
        return this.driver;
    }

//    public DesiredCapabilities clientCapabilities(){
//
//    }

    public void startSession(){

    }

    public void stopSession(){

    }
}
