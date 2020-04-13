package testSteps;

/**
 * Love
 */

import constants.Constants;
import library.AppiumLibrary;
import sessions.SessionManager;
import utilities.PropertyReader;
import java.util.Properties;

public class SearchSteps {
    private AppiumLibrary appiumLibrary;
    private Properties searchScreen = PropertyReader.readLocatorProperties("searchScreen.properties");

    public SearchSteps(SessionManager sessionManager) {
        appiumLibrary = new AppiumLibrary(sessionManager);
    }

    public void selectInvokeSearch() {
        appiumLibrary.click(searchScreen.getProperty("invokeSearch"));
    }

    public void selectQuerySearhResults() {
        appiumLibrary.click(searchScreen.getProperty("querySearchResult"));
    }

    public void clickOnSearchRequested() {
        appiumLibrary.click(searchScreen.getProperty("onSearchRequested"));
    }

    public boolean isOnSearchDisplayed(){
        return appiumLibrary.isElementPresent(searchScreen.getProperty("onSearchRequested"), Constants.ELEMENT_EXPLICIT_WAIT);
    }
    public void enterPrefilQuery(String text) {
        appiumLibrary.enterText(searchScreen.getProperty("enterPrefilQuery"), text);
    }

    public void enterAppData(String text){
        appiumLibrary.enterText(searchScreen.getProperty("appData"),text);
    }

    public void enterTextInSearchField(String text){
        appiumLibrary.enterText(searchScreen.getProperty("searchedText"),text);
    }

    public String getSearchText(){
        return appiumLibrary.getTextAttribute(searchScreen.getProperty("searchedText"));
    }

    public String getQuerySearchTitle(){
        return appiumLibrary.getTextAttribute(searchScreen.getProperty("queryTitle"));
    }

}
