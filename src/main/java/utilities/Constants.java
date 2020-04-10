package utilities;

import java.io.File;

public class Constants {
        public static String PROJECT_PATH = System.getProperty("user.dir");

        public static String slash = File.separator;

        public static String SRC_DIRECTORY_PATH = PROJECT_PATH + slash + "src";

        public static String MAIN_DIRECTORY_PATH = SRC_DIRECTORY_PATH + slash + "main";

        public static String JAVA_DIRECTORY_PATH = MAIN_DIRECTORY_PATH + slash + "java";

        public static String RESOURCE_DIRECTORY_PATH = MAIN_DIRECTORY_PATH + slash + "resources";

        public static String CAPABILITIES_DIRECTORY_PATH = RESOURCE_DIRECTORY_PATH + slash + "capabilities";

        public static String ANDROID_CAPABILITIES_PATH = CAPABILITIES_DIRECTORY_PATH + slash + "androidCapabilities.properties";
}
