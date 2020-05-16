package testSteps;

import library.AppiumLibrary;
import sessions.SessionManager;
import utilities.PropertyReader;

import java.util.Properties;

public class MainPageSteps {
    private AppiumLibrary appiumLibrary;
    private Properties mainPage = PropertyReader.readLocatorProperties("mainScreen.properties");

    public MainPageSteps(SessionManager sessionManager) {
        appiumLibrary = new AppiumLibrary(sessionManager);
    }

    public void selectAccessibilityOption() {
        appiumLibrary.click(mainPage.getProperty("accessibility"));
    }

    public void selectAnimationOption() {
        appiumLibrary.click(mainPage.getProperty("animation"));
    }

    public void selectAppOption() {
        appiumLibrary.click(mainPage.getProperty("appOption"));
    }

    public void selectContentOption() {
        appiumLibrary.click(mainPage.getProperty("content"));
    }

    public void selectGraphicsOption() {
        appiumLibrary.click(mainPage.getProperty("graphics"));
    }

    public void selectMediaOption() {
        appiumLibrary.click(mainPage.getProperty("media"));
    }

    public void selectNFCOption() {
        appiumLibrary.click(mainPage.getProperty("nfc"));
    }

    public void selectOSOption() {
        appiumLibrary.click(mainPage.getProperty("os"));
    }

    public void selectPreferenceOption() {
        appiumLibrary.click(mainPage.getProperty("preference"));
    }

    public void selectTextOption() {
        appiumLibrary.click(mainPage.getProperty("text"));
    }

    public void selectViewOption() {
        appiumLibrary.click(mainPage.getProperty("views"));
    }
}
