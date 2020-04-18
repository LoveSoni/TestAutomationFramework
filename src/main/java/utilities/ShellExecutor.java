package utilities;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor {
    private Logger logger = Logger.getLogger(ShellExecutor.class);

    public static StringBuilder executeCommand(String command) {
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
        return output;
    }

    public static void getListOfConnectedDevices() {
        String platformOs = EnvironmentFields.getPlatformOs();
        if (platformOs.equalsIgnoreCase("android")) {
            System.out.print(executeCommand("adb devices"));
        } else if (platformOs.equalsIgnoreCase("ios")) {

        }
    }

    public static void main(String args[]) {
        getListOfConnectedDevices();
    }


}
