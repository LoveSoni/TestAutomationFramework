package library;

/**
 * author Love
 */

import org.openqa.selenium.WebDriver;
import sessions.WebSession;

public class WebLibrary {
    private WebDriver driver;

    public WebLibrary(WebSession webSession){
        driver = webSession.getDriver();
    }

}
