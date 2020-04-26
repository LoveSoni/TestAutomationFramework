package constants;

import java.io.File;

/**
 * author Love
 */
public class Defaults {
    private static String slash = File.separator;

    public static String DEFAULT_ENVIRONMENT_PATH = System.getProperty("user.dir") + slash + "src" + slash + "main" + slash + "resources" + slash + "environments" + slash + "defaultEnvironment.properties";
}
