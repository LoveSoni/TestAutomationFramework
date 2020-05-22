package listeners;

import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import utilities.ShellExecutor;

import java.util.HashMap;
import java.util.List;

public class TestngGenerator {
    private List<String> udidList =ShellExecutor.getListOfConnectedDevices();
    private int numberOfDeviceConnected = udidList.size();

    @Test
    public void generateTestng(){
        XmlSuite xmlSuite = prepareXmlSuite();
    }

    public XmlSuite prepareXmlSuite(){
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Dynamic Suite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(numberOfDeviceConnected);
        return xmlSuite;
    }

    public XmlTest prepareXmlTest(XmlSuite xmlSuite, String udid){
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setParameters(new HashMap<String,String>(){
            {
                put("udid",udid);
            }
        });
        return xmlTest;
    }

}
