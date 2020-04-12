package testSteps;

import library.AppiumLibrary;
import sessions.SessionManager;
import utilities.PropertyReader;

import java.util.Properties;

public class AppPageSteps {
    private AppiumLibrary appiumLibrary;
    private Properties appPageOptions = PropertyReader.readLocatorProperties("appOptionScreen.properties");

    public AppPageSteps(SessionManager sessionManager){
        appiumLibrary = new AppiumLibrary(sessionManager);
    }

    public void selectActionBar(){
        appiumLibrary.click(appPageOptions.getProperty("actionBar"));
    }

    public void selectAcitivity(){
        appiumLibrary.click(appPageOptions.getProperty("activity"));
    }

    public void selectAlertDialog(){
        appiumLibrary.click(appPageOptions.getProperty("alertDialogs"));
    }

    public void selectDeviceAdmin(){
        appiumLibrary.click(appPageOptions.getProperty("deviceAdmin"));
    }

    public void selectFragment(){
        appiumLibrary.click(appPageOptions.getProperty("fragment"));
    }

    public void selectLanucherShortcuts(){
        appiumLibrary.click(appPageOptions.getProperty("launcherShortcuts"));
    }

    public void selectLoader(){
        appiumLibrary.click(appPageOptions.getProperty("loader"));
    }

    public void selectMenu(){
        appiumLibrary.click(appPageOptions.getProperty("menu"));
    }

    public void selectNotifications(){
        appiumLibrary.click(appPageOptions.getProperty("notifications"));
    }

    public void selectSearch(){
        appiumLibrary.click(appPageOptions.getProperty("search"));
    }

    public void selectService(){
        appiumLibrary.click(appPageOptions.getProperty("service"));
    }

    public void selectTextToSpeech(){
        appiumLibrary.click(appPageOptions.getProperty("textToSpeech"));
    }

    public void selectVoiceRecognition(){
        appiumLibrary.click(appPageOptions.getProperty("voiceRecognition"));
    }
}
