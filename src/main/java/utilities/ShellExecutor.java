package utilities;

import constants.Constants;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ShellExecutor {
    private static Logger logger = Logger.getLogger(ShellExecutor.class);
    private static Properties commandProperties = PropertyReader.readProperty(Constants.SHELL_COMMAND_PROPERTIES_PATH);

    public static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (IOException e) {

        }
        return output.toString();
    }

    public static String getListOfConnectedDevices() {
        String output = executeCommand(commandProperties.getProperty("devicesList"));
        String deviceUdidDetails = output.split("\n")[1];
        String udid = deviceUdidDetails.split("\t")[0];
        return udid;
    }


}
