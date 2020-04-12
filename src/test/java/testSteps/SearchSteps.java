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

    public SearchSteps(SessionManager sessionManager)
    {
        appiumLibrary = new AppiumLibrary(sessionManager);
    }

    public void selectInvokeSearch(){
        appiumLibrary.click(searchScreen.getProperty("invokeSearch"));
    }

    public void selectQuerySearhResults(){
        appiumLibrary.click(searchScreen.getProperty("querySearchResult"));
    }


}
