package listeners;

import org.testng.annotations.Test;
import utilities.ShellExecutor;

public class TestngGenerator {

    @Test
    public void generateTestng(){
        System.out.println(ShellExecutor.getListOfConnectedDevices());
    }

}
