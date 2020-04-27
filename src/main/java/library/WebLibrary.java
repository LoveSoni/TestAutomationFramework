package library;

/**
 * author Love
 */

import constants.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessions.WebSession;

public class WebLibrary {
    private WebDriver driver;
    private Logger logger = Logger.getLogger(WebLibrary.class);
    private ElementLocator elementLocator = new ElementLocator();

    public WebLibrary(WebSession webSession){
        driver = webSession.getDriver();
    }

    public void click(String locator){
        isElementPresent(locator,Constants.ELEMENT_EXPLICIT_WAIT);
        getWebElement(locator).click();
    }

    public boolean isElementVisible(String locator,int time){
        boolean res = false;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, time);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator.locateElement(locator)));
            res = true;
        }catch (TimeoutException timeoutException){
            logger.error("Element - "+ elementLocator.locateElement(locator)+" is not Visible");
        }
        return res;
    }

    public void isElementPresent(String locator,int time){
        boolean res = false;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,time);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator.locateElement(locator)));
            res = true;
        }catch (TimeoutException timeoutException){
            logger.error("Element - "+elementLocator.locateElement(locator)+" is not Present in DOM");
        }
    }

    public WebElement getWebElement(String locator){
        return driver.findElement(elementLocator.locateElement(locator));
    }

}
