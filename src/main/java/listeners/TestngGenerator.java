package listeners;

import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import utilities.ShellExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestngGenerator {
    private String testsName = "LoginTest,DemoTest1,DemoTest2";
    private List<String> udidList = ShellExecutor.getListOfConnectedDevices();
    private int numberOfDeviceConnected = udidList.size();
    private Logger logger = Logger.getLogger(TestngGenerator.class);

    @Test
    public void generateTestng() {
        if (numberOfDeviceConnected < 1) {
            logger.error("No device is connected");
        } else {
            XmlSuite xmlSuite = prepareXmlSuite();
            udidList.forEach(udid -> {
                                divideList(getTestList(),numberOfDeviceConnected);
                        XmlTest xmlTest = prepareXmlTest(xmlSuite, udid);
                    }
            );
            logger.info("Xml Suite Prepared - \n" + xmlSuite.toXml());
        }

    }

    public List divideList(List<String> methodList, int noOfDevices) {
        return new ArrayList(IntStream.range(0, methodList.size()).boxed().collect(
                Collectors.groupingBy(e -> e % noOfDevices, Collectors.mapping(e -> methodList.get(e), Collectors.toList())
                )).values());
    }

    public List<String> getTestList() {
        String[] testClasses = testsName.split(",");
        return Arrays.asList(testClasses);
    }

    public void runTestngTests(List<XmlSuite> xmlSuite) {
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(xmlSuite);
        testNG.run();
    }

    public XmlSuite prepareXmlSuite() {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Dynamic Suite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(numberOfDeviceConnected);
        return xmlSuite;
    }

    public XmlTest prepareXmlTest(XmlSuite xmlSuite, String udid) {
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setParameters(new HashMap<String, String>() {
            {
                put("udid", udid);
            }
        });
        return xmlTest;
    }

}
