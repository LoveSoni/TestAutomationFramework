package utilities;

import constants.Constants;

import java.util.Properties;

public class EnvironmentParameter {
    private static  String platformOs = System.getProperty("platformOs");

    private static String testEnvironment = System.getProperty("testEnvironment");

    private static Properties defaultEnvironmentProperties = PropertyReader.readProperty(Constants.DEFAULT_ENVIRONMENT_PROPERITES_PATH);

    public static String getPlatformOs(){
        return platformOs==null ? getDefaultPlatformOs() :platformOs;
    }

    public static String getTestEnvironment(){
        return testEnvironment == null ? getDefaultTestEnvironment() : getDefaultTestEnvironment();
    }
    public static  String getDefaultPlatformOs(){
        return defaultEnvironmentProperties.getProperty("platformOs");
    }

    public static String getDefaultTestEnvironment(){
        return defaultEnvironmentProperties.getProperty("testEnvironment");
    }
}
