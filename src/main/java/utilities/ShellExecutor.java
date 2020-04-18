package utilities;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor {
    private Logger logger = Logger.getLogger(ShellExecutor.class);

    public static StringBuilder executeCommand(String command){
        StringBuilder output = new StringBuilder();
        try {
           Process process =  Runtime.getRuntime().exec(command);
           String line;
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
           while((line = bufferedReader.readLine())!=null){
                output.append(line+"\n");
           }
           System.out.print(output.toString());
        }catch (IOException e){

        }
        return output;
    }

    public void getListOFDevices(){

    }


}
