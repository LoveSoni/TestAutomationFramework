package listeners;

import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import utilities.ShellExecutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestngGenerator {
    private String testsName = System.getProperty("user.dir");
    private List<String> udidList = ShellExecutor.getListOfConnectedDevices();
    private int numberOfDeviceConnected = udidList.size();
    private Logger logger = Logger.getLogger(TestngGenerator.class);

    @Test
    public void generateTestng() {
        if (numberOfDeviceConnected < 1) {
            logger.error("No device is connected");
        } else {
            XmlSuite xmlSuite = prepareXmlSuite();
            for (int k = 0; k < udidList.size(); k++) {
                List<List<String>> testClassList = divideList(getTestList(), numberOfDeviceConnected);
                logger.info("Test List :" + testClassList);
                XmlTest xmlTest = prepareXmlTest(xmlSuite, udidList.get(k));
                List<XmlClass> xmlClassList = new ArrayList();
                for (int p = 0; p < testClassList.size(); p++) {
                    for (int i = 0; i < testClassList.get(p).size(); i++) {
                        XmlClass xmlClass = prepareXmlClass(testClassList.get(p).get(i));
                        List<XmlInclude> xmlIncludeList = new ArrayList<>();
                        List<List<String>> methodList = divideList(getTestClassMethods(testClassList.get(p).get(i)), numberOfDeviceConnected);
                        logger.info("Method List for Test Class " + testClassList.get(p).get(i) + " : " + methodList);
                        if (!(getTestClassMethods(testClassList.get(p).get(i)).size() < k + 1)) {
                            for (int j = 0; j < methodList.get(k).size(); j++) {
                                XmlInclude xmlInclude = prepareIncludeMethod(methodList.get(k).get(j));
                                xmlIncludeList.add(xmlInclude);
                            }
                            xmlClass.setIncludedMethods(xmlIncludeList);
                            xmlClassList.add(xmlClass);
                        }
                    }
                    xmlTest.setClasses(xmlClassList);
                }

            }
            logger.info("Xml Suite Prepared - \n" + xmlSuite.toXml());
        }
    }

    public XmlInclude prepareIncludeMethod(String methodName) {
        return new XmlInclude(methodName);
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

    public XmlClass prepareXmlClass(String className) {
        XmlClass xmlClass = new XmlClass("testClasses." + className);
        return xmlClass;
    }

    public List<String> getTestClassMethods(String testClass) {
        List<String> methods = new ArrayList<>();
        try {
            Method[] method = Class.forName("testClasses." + testClass).getMethods();
            for (Method meth : method) {
                Annotation anotate[] = meth.getAnnotations();
                for (Annotation anot : anotate) {
                    if (anot.toString().contains("org.testng.annotations.Test")) {
                        methods.add(meth.getName());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methods;
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
