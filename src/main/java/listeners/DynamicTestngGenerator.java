package listeners;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGMethod;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicTestngGenerator implements ISuiteListener {
    private static Logger logger = Logger.getLogger(DynamicTestngGenerator.class);
    @Override
    public void onStart(ISuite suite) {
        System.out.print("in the onstart method");
        List<ITestNGMethod> list = suite.getAllMethods();
        System.out.println(list.size());
        for (ITestNGMethod li : list) {
            System.out.println(li.getMethodName());
        }
    }

    public static void main(String args[]) {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("dynamic suite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(2);

        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("parallel test");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("udid", "emulator-5554");
        xmlTest.setParameters(parameters);

        List<XmlClass> xmlClasses = new ArrayList<>();
        XmlClass xmlClass = new XmlClass("");
        xmlClasses.add(xmlClass);

        xmlTest.setXmlClasses(xmlClasses);


        List<XmlSuite> xmlSuites = new ArrayList<>();
        xmlSuites.add(xmlSuite);


        TestNG testNG = new TestNG();
        testNG.setXmlSuites(xmlSuites);
        testNG.run();

        FileWriter writer;
        try {
            writer = new FileWriter(new File("TestngDyn.xml"));
            writer.write(xmlSuite.toXml());
            writer.flush();
            writer.close();
            logger.info(new File("TestngDyn.xml").getAbsolutePath());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public XmlSuite prepareXmlSuite(int noOfDevices){
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Dynamic Suite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(noOfDevices);
        return xmlSuite;
    }
}
