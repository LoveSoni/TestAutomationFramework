package listeners;

import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import utilities.ShellExecutor;

import java.util.List;

public class TestngGenerator {
    private List<String> udidList =ShellExecutor.getListOfConnectedDevices();
    private int numberOfDeviceConnected = udidList.size();

    @Test
    public void generateTestng(){

    }

    public XmlSuite prepareXmlSuite(){
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Dynamic Suite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(numberOfDeviceConnected);
        return xmlSuite;
    }

}
