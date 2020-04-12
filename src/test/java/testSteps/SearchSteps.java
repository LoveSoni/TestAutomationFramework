package testSteps;

/**
 * Love
 */

import library.AppiumLibrary;
import sessions.SessionManager;
import utilities.PropertyReader;
import java.util.Properties;

public class SearchSteps {
    private AppiumLibrary appiumLibrary;
    private Properties searchScreen = PropertyReader.readLocatorProperties("");

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

    public void enterPrefilQuery(String text) {
        appiumLibrary.enterText(searchScreen.getProperty("txt_query_prefill"), text);
    }

}
