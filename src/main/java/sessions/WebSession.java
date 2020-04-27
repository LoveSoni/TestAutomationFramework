package sessions;

/**
 * author Love
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.EnvironmentFields;

public class WebSession {
    private WebDriver driver;
    private Logger logger = Logger.getLogger(WebSession.class);
    private String browserName = EnvironmentFields.getBrowserName();

    public void initiateDriver(){
        logger.info("Running Test on "+browserName+" Browser");
        setUpBrowser();
    }

    public void setUpBrowser(){
        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromiumdriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                logger.error("Please check the browser name carefully");
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }


}
