package sessions;

/**
 * author Love
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.EnvironmentFields;

public class WebSession {
    private WebDriver driver;
    private Logger logger = Logger.getLogger(WebSession.class);
    private WebDriverManager webDriverManager;
    private String browserName = EnvironmentFields.getBrowserName();

    public void initiateDriver(){

        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){
        return this.driver;
    }


}
