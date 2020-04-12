package testSteps;

/**
 * Love
 */

import library.AppiumLibrary;
import sessions.SessionManager;

public class SearchSteps {
    private AppiumLibrary appiumLibrary;

    public SearchSteps(SessionManager sessionManager)
    {
        appiumLibrary = new AppiumLibrary(sessionManager);
    }
}
