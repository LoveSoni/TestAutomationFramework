package library;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessions.SessionManager;

public class AppiumLibrary {
    private AppiumDriver driver;
    private Logger logger = Logger.getLogger(AppiumLibrary.class);
    private ElementLocator elementLocator;
    private int DEFAULT_TIME_OUT = Constants.ELEMENT_EXPLICIT_WAIT;

    public AppiumLibrary(SessionManager sessionManager) {
        this.driver = sessionManager.getDriver();
    }

    public void click(String element) {
        isElementPresent(element, DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        mobileElement.click();
    }

    public void click(MobileElement element) {
        element.click();
    }

    public void clickIfPresent(String element) {
        boolean isPresent = isElementPresent(element, DEFAULT_TIME_OUT);
        if (isPresent) {
            logger.info("Element " + element + " present and clicking on it.");
            MobileElement mobileElement = getElememnt(element);
            mobileElement.click();
        } else {
            logger.warn("Element " + element + " not present on screen..");
        }
    }

    public void enterText(String element, String text) {
        isElementPresent(element,DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        mobileElement.sendKeys(text);
    }

    public int getScreenHeight(){
        return driver.manage().window().getSize().getHeight();
    }

    public int getScreenWidth(){
        return driver.manage().window().getSize().getWidth();
    }

    public boolean isElementPresent(String element, int time) {
        boolean found = false;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, time);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator.locateElement(element)));
            found = false;
        } catch (TimeoutException timeoutException) {
            logger.error("Element - " + element + " Not Present");
        }
        return found;
    }

    public MobileElement getElememnt(String element) {
        elementLocator = new ElementLocator();
        return (MobileElement) driver.findElement(elementLocator.locateElement(element));
    }
}
