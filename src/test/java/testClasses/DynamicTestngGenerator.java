package testClasses;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGMethod;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicTestngGenerator implements ISuiteListener {
    @Override
    public void onStart(ISuite suite){
        System.out.print("in the onstart method");
        List<ITestNGMethod> list = suite.getAllMethods();
        System.out.println(list.size());
        for (ITestNGMethod li : list){
            System.out.println(li.getMethodName());
        }
    }

    //    @Override
//    public void alter(List<XmlSuite> suites){
//        System.out.println(suites.toString());
//    }
    public static void main(String args[]){
//        XmlSuite xmlSuite = new XmlSuite();
//        xmlSuite.setName("dynamic suite");
//        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
//        xmlSuite.setThreadCount(2);
//
//        XmlTest xmlTest = new XmlTest(xmlSuite);
//        xmlTest.setName("parallel test");
//        Map<String,String> parameters = new HashMap<>();
//        parameters.put("udid","emulator-5554");
//        xmlTest.setParameters(parameters);
//
//        List<XmlClass> xmlClasses = new ArrayList<>();
//        XmlClass xmlClass = new XmlClass(LoginTest.class);
//        xmlClasses.add(xmlClass);
//
//        xmlTest.setXmlClasses(xmlClasses);
//
//
//        List<XmlSuite> xmlSuites = new ArrayList<>();
//        xmlSuites.add(xmlSuite);
//
//
//        TestNG testNG = new TestNG();
//        testNG.setXmlSuites(xmlSuites);
//        testNG.run();


        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Dynamic Suite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.addListener("tests.DynamicTestgnGenerator");
        xmlSuite.setThreadCount(2);
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("login test");
        xmlTest.setParameters(new HashMap<String,String>(){
            {
                put("udid","emulator-5554");
            }
        });

        XmlClass xmlClass = new XmlClass();
        xmlClass.setClass(SearchTest.class);

        List<XmlClass> xmlClasses = new ArrayList<>();
        xmlClasses.add(xmlClass);

        xmlTest.setClasses(xmlClasses);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(new ArrayList<XmlSuite>(){
            {
                add(xmlSuite);
            }
        });
        testNG.run();

    }
}
