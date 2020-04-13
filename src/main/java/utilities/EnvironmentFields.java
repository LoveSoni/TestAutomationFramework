package utilities;

import org.testng.annotations.Test;

public class EnvironmentFields {
    private static String platformOs = System.getProperty("mobilePlatform");

    private static String defaultOs = "android";


    public static String getPlatformOs(){
        return platformOs == null ? getDefaultPlatformOs() : platformOs;
    }

    public static String getDefaultPlatformOs(){
        return defaultOs;
    }

    @Test
    public void test(){
        System.out.print(getPlatformOs());
    }
}
