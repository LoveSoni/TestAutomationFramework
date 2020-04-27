package utilities;

/**
 * author love
 */

import constants.Defaults;
import java.util.Properties;

public class EnvironmentFields {

    private  static  Properties defaultEnvironmentProperties = PropertyReader.readProperty(Defaults.DEFAULT_ENVIRONMENT_PATH);

    private static String testEnvironment = System.getProperty("testEnvironment");

    private static String platformOs = System.getProperty("platformOs");

    private static String browserName = System.getProperty("browserName");

    public static  String getPlatformOs(){
        return platformOs == null ? getDefaultPlatformOs() : platformOs;
    }

    public static String getDefaultPlatformOs(){
        return defaultEnvironmentProperties.getProperty("platformOs");
    }

    public static String getBrowserName(){ return browserName == null ? getDefaultBrowserName() : browserName; }

    public static String getDefaultBrowserName(){ return defaultEnvironmentProperties.getProperty("browserName"); }

    public static String getTestEnvironment(){
        return testEnvironment == null ?  getDefaultTestEnv() :testEnvironment;
    }

    public static String getDefaultTestEnv(){
        return defaultEnvironmentProperties.getProperty("testEnvironment");
    }
}
